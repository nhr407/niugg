package net.modules.threadstudy.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * ThreadLocal类提供了以下几个方法：
 * 1. public T get() { }
 * 2. public void set(T value) { }
 * 3. public void remove() { }
 * 4. protected T initialValue() { }
 * get()方法是用来获取ThreadLocal在当前线程中保存的变量副本，
 * set()用来设置当前线程中变量的副本，
 * remove()用来移除当前线程中变量的副本，
 * initialValue()是一个protected方法，一般是用来在使用时进行重写的，它是一个延迟加载方法
 *
 */
public class ThreadLocalExample implements Runnable {
	// SimpleDateFormat is not thread-safe, so give one to each thread
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		};
	};
	
	public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
	
	@Override
	public void run() {
		System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        formatter.set(new SimpleDateFormat());
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
	}
}
