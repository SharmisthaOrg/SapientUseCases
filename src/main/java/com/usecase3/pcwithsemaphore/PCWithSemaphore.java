package com.usecase3.pcwithsemaphore;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;

public class PCWithSemaphore {
	private static int i=0;

	public static void main(String[] args) throws InterruptedException {
		Semaphore producerSemaphore = new Semaphore(1);
		Semaphore consumerSemaphore = new Semaphore(0);
		Queue<Integer> sharedQ = new ArrayBlockingQueue<>(10); 
		Thread th=new Thread(new Producer(sharedQ, producerSemaphore, consumerSemaphore, i),"P");
		Thread th1=new Thread(new Consumer(sharedQ, producerSemaphore, consumerSemaphore,i),"C");
		th.start();
		Thread.currentThread().sleep(100);
		th1.start();
	}

}
class Producer implements Runnable{
	private Queue<Integer> sharedQ;
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;
	private int i;
	public Producer(Queue<Integer> sharedQ,Semaphore producerSemaphore,Semaphore consumerSemaphore,int i) {
		this.sharedQ = sharedQ;
		this.producerSemaphore = producerSemaphore;
		this.consumerSemaphore = consumerSemaphore;
		this.i = i;
	}
	public void run() {
		while(true) {
			try {
				if(sharedQ.size()>10) {
					System.err.println("SharedList is full");
				}
				else {
					producerSemaphore.acquire();
					sharedQ.add(i);
					System.out.println((i++)+"Produced by "+Thread.currentThread().getName());
					consumerSemaphore.release();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
class Consumer implements Runnable{
	private Queue<Integer> sharedQ;
	private Semaphore producerSemaphore;
	private Semaphore consumerSemaphore;
	private int i;
	public Consumer(Queue<Integer> sharedQ,Semaphore producerSemaphore,Semaphore consumerSemaphore,int i) {
		this.sharedQ = sharedQ;
		this.producerSemaphore = producerSemaphore;
		this.consumerSemaphore = consumerSemaphore;
		this.i = i;
	}
	public void run() {
		while(true) {
			try {
				if(sharedQ.size()==0) {
					System.err.println("SharedList is empty");
				}
				else {
					consumerSemaphore.acquire();
					System.out.println(sharedQ.remove()+"is Consumer by "+Thread.currentThread().getName());
					producerSemaphore.release();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}