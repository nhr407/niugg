package net.modules.threadstudy.threadsafety;
/**
 * 线程不安全：
 * 多个线程使用同一个对象的成员变量时会发生线程不安全的问题
 * we know that multiple threads created from same Object share object variables and this 
 * can lead to data inconsistency when the threads are used to read and update the shared data.
 * 
 * 如何使线程变得安全：
 * 1. Synchronization is the easiest and most widely used tool for thread safety in java.
 * 2. Use of Atomic Wrapper classes from java.util.concurrent.atomic package. For example AtomicInteger
 * 3. Use of locks from java.util.concurrent.locks package.
 * 4. Using thread safe collection classes, e.g. ConcurrentHashMap.
 * 5. Using volatile keyword with variables to make every thread read the data from memory, not read from thread cache.
 * 
 *
 */
public class ThreadUnSafety {
	public static void main(String[] args) throws InterruptedException {
		ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");  // 使用pt对象创建线程t1
        t1.start();
        Thread t2 = new Thread(pt, "t2"); // 使用pt对象创建线程t2
        t2.start();
        //wait for threads to finish processing
        t1.join();
        t2.join();
        System.out.println("Processing count="+pt.getCount());
	}
}


class ProcessingThread implements Runnable{
    private int count;
    
    @Override
    public void run() {
        for(int i=1; i< 5; i++){
            processSomething(i);
        	count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}