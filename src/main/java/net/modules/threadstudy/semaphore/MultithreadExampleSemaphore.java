package net.modules.threadstudy.semaphore;

import java.util.concurrent.Semaphore;

public class MultithreadExampleSemaphore {
	static volatile int counter = 0;
	static Semaphore semaphore = new Semaphore(1);
	
	public static void incrementCounter(){
		try {
			semaphore.acquire();
			counter ++;
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5000; i++) {
					incrementCounter();
				}
			}
		}, "thread1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<5000; i++) {
					incrementCounter();
				}
			}
		}, "thread2");
		
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive()) {}
		System.out.println("Counter=" + counter);
	}
}
