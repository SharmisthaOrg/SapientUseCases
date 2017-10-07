package com.usecase2.multipleproducerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class MultiplePC {
	static int count=0;
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		int limit=10;
		for(int i=0;i<10;i++) {
			new Thread(new MultiplePC().new Producer(q,limit),"PT:"+i).start();
		}
		for(int i=0;i<10;i++) {
			new Thread(new MultiplePC().new Consumer(q,limit),"CT:"+i).start();
		}

	}
	class Producer implements Runnable{
		private Queue<Integer> sharedQueue;
		private int limit;
		public Producer(Queue<Integer> sharedQueue,int limit) {
			this.sharedQueue = sharedQueue;
			this.limit = limit;
		}

		public void run() {
			while(count<100)
				synchronized(sharedQueue){
					if(sharedQueue.size() == limit) {
						try {
							System.out.println("Queue is full");
							sharedQueue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(count+" is Produced by"+Thread.currentThread().getName());
					sharedQueue.add(count++);
					sharedQueue.notifyAll();
				}

		}

	}
	class Consumer implements Runnable{
		private Queue<Integer> sharedQueue;
		private int limit;
		public Consumer(Queue<Integer> sharedQueue,int limit) {
			this.sharedQueue = sharedQueue;
			this.limit = limit; 
		}

		public void run() {

			while(count<100)
				synchronized(sharedQueue){
					if(sharedQueue.size() <1) {
						try {
							System.out.println("Queue is empty");
							sharedQueue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(sharedQueue.remove()+" is Consumed by"+Thread.currentThread().getName());

					sharedQueue.notifyAll();
				}
		}
	}
}
