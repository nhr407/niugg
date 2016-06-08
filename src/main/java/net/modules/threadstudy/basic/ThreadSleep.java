package net.modules.threadstudy.basic;

/**
 * java.lang.Thread sleep() method can be used to pause the execution of current thread for specified time in milliseconds. 
 * 
 * 1. It always pause the current thread execution.
 * 2. The actual time thread sleeps before waking up and start execution depends on system timers 
 * and schedulers. For a quiet system, the actual time for sleep is near to the specified sleep time 
 * but for a busy system it will be little bit more.
 * 3. Thread sleep doesn’t lose any monitors or locks current thread has acquired.
 * 4. Any other thread can interrupt the current thread in sleep, in that case InterruptedException is thrown.
 */
public class ThreadSleep {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
	}
}
