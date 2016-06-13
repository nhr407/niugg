package net.modules.threadstudy.pool;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void run() {
		try {
            Long duration = (long) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName()+" Start. Command = "+ name); 
            TimeUnit.SECONDS.sleep(duration);
            System.out.println(Thread.currentThread().getName()+" End.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
