package com.usecase3.pcwithcutomblockingqueue;
/*package com.pcwithcutomblockingqueue;

public class PCWithMyLinkedBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		int capacity =10;
		CustomLinkedBlockignQueue<Integer> sq=new CustomLinkedBlockignQueue<>(capacity);
		for(int i=0;i<5;i++) {
			Thread th=new Thread(new Producer(sq, capacity),"Producer_"+i);
			th.start();
		}
		Thread.sleep(100);
		for(int i=0;i<5;i++) {
			Thread th=new Thread(new Consumer(sq, capacity),"Consumer_"+i);
			th.start();
		}

	}

}
class Producer implements Runnable{
	private CustomLinkedBlockignQueue<Integer> sq;
	private int capacity;
	private static volatile int value=0;

	public Producer(CustomLinkedBlockignQueue<Integer> sq,int capacity) {
		this.sq = sq;
		this.capacity = capacity;
	}


	public void run() {
		while(true) {
			try {
				if(sq.size() == capacity) {
					System.out.println("bucket is full");
				}
				else {
					System.out.println(Thread.currentThread().getName()+" puts:"+value);
					sq.put(value++);
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
class Consumer implements Runnable{
	private CustomLinkedBlockignQueue<Integer> sq;
	private int capacity;
	private static int value=0;

	public Consumer(CustomLinkedBlockignQueue<Integer> sq,int capacity) {
		this.sq = sq;
		this.capacity = capacity;
	}


	public void run() {
		while(true) {
			try {
				if(sq.size() == 0) {
					System.out.println("bucket is empty");
				}
				else {
					System.out.println(Thread.currentThread().getName()+" consumes: "+sq.take());
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}*/