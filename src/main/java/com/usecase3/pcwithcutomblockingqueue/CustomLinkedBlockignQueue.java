package com.usecase3.pcwithcutomblockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



public class CustomLinkedBlockignQueue<E> {
	static class Node<E>{
		E item;
		Node<E> next;
		Node(E item){
			this.item = item;
		}
	}
	private final int capacity;
	private Node<E> head;
	private Node<E> last;
	private final AtomicInteger count=new AtomicInteger();
	private final ReentrantLock putLock=new ReentrantLock();
	private final ReentrantLock takeLock=new ReentrantLock();
	private final Condition putWhenNotFull=putLock.newCondition();
	private final Condition takeWhenNotEmpty = takeLock.newCondition();
	
	public CustomLinkedBlockignQueue(int capacity) {
		if (capacity <= 0) throw new IllegalArgumentException();
		this.capacity = capacity;
		this.head = this.last = new Node<E>(null);
	}
	public void put(E e) throws InterruptedException {
		if(e == null)throw new NullPointerException("Value cannot be null");
		Node<E> n=new Node<E>(e);
		putLock.lockInterruptibly();
		try {
			if(count.get() == capacity) {
				putWhenNotFull.await();
			}
			enqueue(n);
			System.out.println(Thread.currentThread().getName()+" put :"+n.item);
			count.getAndIncrement();
			takeWhenNotEmpty.signal();
		}
		finally {
			this.putLock.unlock();
		}

	}
	private void enqueue(Node<E> n) {
		// node <- last 
		last = last.next = n;	
	}
	public E take() throws InterruptedException {
		//takeLock.lockInterruptibly();
		takeLock.lock();
		
		try {
			if(count.get() ==0) {
				takeWhenNotEmpty.await();
			}
			E e=dequeue();
			count.decrementAndGet();
			putWhenNotFull.signalAll();
		}
		finally {
			takeLock.unlock();
		}
		return null;

	}
	private E dequeue() {
		
		Node<E> first=head.next;
		E i=first.item;
		head.next = first.next;
		return i;
	}
	public static void main(String[] args) {
		CustomLinkedBlockignQueue mm=new CustomLinkedBlockignQueue(10);
		for(int i=1;i<=10;i++) {
			mm.enqueue(new Node(i));
		}
		System.out.println(mm.head.item);
		for(int i=1;i<=10;i++) {
			System.out.println(mm.dequeue());
		}
	}
	public int size() {
		// TODO Auto-generated method stub
		return count.get();
	}

}
