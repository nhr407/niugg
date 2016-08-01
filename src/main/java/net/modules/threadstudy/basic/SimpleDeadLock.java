package net.modules.threadstudy.basic;

public class SimpleDeadLock {
	
	public static Object o1 = new Object();
	public static Object o2 = new Object();

	public static void main(String[] args) {
		System.out.println("o1:" + o1);
		System.out.println("o2:" + o2);
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized (o1) {
					System.out.println("Thread1: holding lock o1 ...");
					try {
						Thread.sleep(10);
					}catch(InterruptedException e){}
					System.out.println("Thread1: Waiting for lock o2 ...");
					synchronized (o2) {
						System.out.println("Thread2: Holding lock o1 and o2 ...");
					}
				}
			}}, "thread1");
		Thread t2 = new Thread(new Runnable() {
			public void run(){
				synchronized (o2) {
					System.out.println("Thread2: holding lock o2 ...");
					try {
						Thread.sleep(10);
					}catch(InterruptedException e){}
					System.out.println("Thread2: Waiting for lock o1 ...");
					synchronized (o1) {
						System.out.println("Thread2: Holding lock o2 and o1 ...");
					}
			}
		}}, "thread2");
		
		t1.start();t2.start();

	}
}
