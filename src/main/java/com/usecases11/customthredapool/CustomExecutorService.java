package com.usecases11.customthredapool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomExecutorService {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService es=Executors.newFixedThreadPool(30);
		es.execute(()->System.out.println("hello"));
		es.shutdown();
		
		MyFixedThreadPoolProducer m=new MyFixedThreadPoolProducer(7);
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 1");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 2");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 3");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 4");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 5");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 6");

			}

		});
		m.execute(new Runnable() {

			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName() +" is running for 7");

			}

		});
		m.shutDown();
		

	}

}

class MyFixedThreadPoolProducer {
	private int capacity;
	private ArrayBlockingQueue<Runnable> abq;
	private volatile boolean isShutDownInitiated = false;
	private AtomicInteger workercount = new AtomicInteger(0);
	private List<WorkerThreadConsumer> workers=new CopyOnWriteArrayList<>();
	public MyFixedThreadPoolProducer(int capacity) {
		this.capacity = capacity;
		this.abq = new ArrayBlockingQueue<>(capacity);
		
		/*for(int i=0;i<capacity;i++) {
			WorkerThreadConsumer w=new WorkerThreadConsumer(abq, this,"WorkerThread"+i);w.start();
		}*/
	}

	public void shutDown() {
		this.isShutDownInitiated = true;
		for(WorkerThreadConsumer w:workers) {
			synchronized (w) {
				w.interrupt();
			}			
		}
	}

	public void execute(Runnable runnable)  {
		if(this.isShutDownInitiated)
	           throw new RuntimeException("ThreadPool has been shutDown, no further tasks can be added");
		if(workercount.get() < capacity) {
			WorkerThreadConsumer w=new WorkerThreadConsumer(abq, this,"WorkerThread"+workercount.get());
			w.start();
	    	workercount.incrementAndGet();
	    	workers.add(w);
	    }
		try {
			abq.put(runnable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public boolean shutDownInitiated() {
		
		return this.isShutDownInitiated ;
	}

}
class WorkerThreadConsumer extends Thread{
	private ArrayBlockingQueue<Runnable> abq;
	private MyFixedThreadPoolProducer producer;
	public WorkerThreadConsumer(ArrayBlockingQueue<Runnable> abq,MyFixedThreadPoolProducer producer, String string) {
		super(string);
		this.abq = abq;
		this.producer = producer;
		
	}
	public void run() {
		while(true) {
			try {
				if(producer.shutDownInitiated() == true && abq.size() ==0 ) {
					System.out.println("Task completed"+Thread.currentThread().getName());
					this.interrupt();
					//Thread.sleep(1);
					break;
				}				
				abq.take().run();
				//Thread.sleep(1);

			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
				
			}
		}

	}
}