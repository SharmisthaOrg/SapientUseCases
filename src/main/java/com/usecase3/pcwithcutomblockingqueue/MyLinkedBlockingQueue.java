package com.usecase3.pcwithcutomblockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyLinkedBlockingQueue<E> {
	static class Node<E>{
		E item;
		Node<E> next;
		Node(E item){
			this.item = item;
		}
	}
	private final int capacity;

	private final AtomicInteger count = new AtomicInteger();

	transient Node<E> head;

	private transient Node<E> last;

	/** Lock held by take, poll, etc */
	private final ReentrantLock takeLock = new ReentrantLock();

	/** Wait queue for waiting takes */
	private final Condition notEmpty = takeLock.newCondition();

	/** Lock held by put, offer, etc */
	private final ReentrantLock putLock = new ReentrantLock();

	/** Wait queue for waiting puts */
	private final Condition notFull = putLock.newCondition();

	public MyLinkedBlockingQueue(int capacity) {
		if (capacity <= 0) throw new IllegalArgumentException();
		this.capacity = capacity;
		last = head = new Node<E>(null);


	}

	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signal();
		}
		finally {
			takeLock.unlock();
		}
	}
	private void signalNotFull() {
		final ReentrantLock putLock = this.putLock;
		putLock.lock();
		try {
			notFull.signal();
		}
		finally {
			putLock.unlock();
		}    	
	}
	private void enqueue(Node<E> node) {		
		// node <- last 
		last = last.next=node;

	}

	private E dequeue() {

		Node<E> h = head;//null
		Node<E> first = h.next;//10
		h.next = h; // help GC 
		head = first;
		E x = first.item;
		first.item = null;
		return x;
	}


	public static void main(String[] args) {
		MyLinkedBlockingQueue mm=new MyLinkedBlockingQueue(10);
		for(int i=1;i<=10;i++) {
			mm.enqueue(new Node(i));
		}
		System.out.println(mm);
		for(int i=1;i<=10;i++) {
			System.out.println(mm.dequeue());
		}
	}

	public void put(E e) throws InterruptedException {
		if(e == null) throw new NullPointerException("Value cannot be null");
		Node<E> node = new Node<E>(e);
		int c = -1;
		final ReentrantLock putLock = this.putLock;
		putLock.lockInterruptibly();
		try {
			final AtomicInteger count = this.count;
			while (count.get() == capacity) {
				notFull.await();
			}
			enqueue(node);
			c = count.getAndIncrement();
			if(c+1 < capacity) {
				notFull.signal();
			}
		}
		finally {
			putLock.unlock();
		}
		if (c == 0)
			signalNotEmpty();
	}

	public E take() throws InterruptedException {
		E x;
		int c = -1;
		final AtomicInteger count = this.count;
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lockInterruptibly();
		try {
			if(count.get() == 0) {
				notEmpty.await();
			}
			x = dequeue();
			c = count.getAndDecrement();
			if(c > 1) {
				notEmpty.signal();
			}
		}
		finally{
			takeLock.unlock();
		}
		if(c == capacity) 
			signalNotFull();

		return x;
	}

}
