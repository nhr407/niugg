package net.modules.threadstudy.waitnotify;

/**
 * A class that will wait for other threads to invoke notify methods to complete it’s processing. 
 * Notice that Waiter thread is owning monitor on Message object using synchronized block.
 * 
 * 注意：Thread.sleep()方法不会释放锁。Object.wait()方法会释放锁。
 * wait()方法可以使调用该方法的线程释放共享资源的锁，然后从运行状态退出，进入等待队列，直到被再次唤醒。
 * notify()方法可以随机唤醒等待队列中等待同一共享资源的“一个”线程，并使该线程退出等待队列，进入可运行状态，也就是notify()方法仅通知“一个”线程。
 * nofityAll()方法可以使所有正在等待队列中等待同一共享资源的“全部”线程从等待状态退出，进入可运行状态。
 * wait(long) 等待某一时间内是否有线程对锁进行唤醒，如果超过这个时间则会自动唤醒。
 * 注意：notify()执行后，并不会立即释放锁，而是执行完代码后，才会释放，CPU随机选择一个wait状态的线程，获得锁，并执行。
 */
public class Waiter implements Runnable {

	private Message msg;
    
    public Waiter(Message m){
        this.msg=m;
    }
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		synchronized(msg) {
			try{
                System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
            //process the message now
            System.out.println(name+" processed: "+msg.getMsg());
		}
	}

}
