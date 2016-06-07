package net.modules.threadstudy.basic;

/**
 * Runnable vs Thread
 * If your class provides more functionality rather than just running as Thread, 
 * you should implement Runnable interface to provide a way to run it as Thread. 
 * If your class only goal is to run as Thread, you can extend Thread class.
 *
 * Implementing Runnable is preferred because java supports implementing multiple 
 * interfaces. If you extend Thread class, you can’t extend any other classes.
 */
public class ThreadRunExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
        System.out.println("Starting MyThreads");
        t3.start();
        t4.start();
        System.out.println("MyThreads has been started");
	}
}
