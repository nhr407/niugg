package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

import java.util.Random;

/**
 * ReentrantLock 实现了标准的互斥操作，也就是一次只能有一个线程持有锁，
 * 也即所谓独占锁的概念。前面的章节中一直在强调这个特点。显然这个特点在
 * 一定程度上面减低了吞吐量，实际上独占锁是一种保守的锁策略，在这种情况
 * 下任何“读/读”，“写/读”，“写/写”操作都不能同时发生。但是同样需要强调
 * 的一个概念是，锁是有一定的开销的，当并发比较大的时候，锁的开销就比较
 * 客观了。所以如果可能的话就尽量少用锁，非要用锁的话就尝试看能否改造为
 * 读写锁。
 * 
 * ReadWriteLock 描述的是：一个资源能够被多个读线程访问，或者被一个写
 * 线程访问，但是不能同时存在读写线程。也就是说读写锁使用的场合是一个共
 * 享资源被大量读取操作，而只有少量的写操作（修改数据）。
 *
 */
public class Run {

	public static void main(String[] args) {
		final UsingReadWriteLock urwl = new UsingReadWriteLock();
		// 1个线程在写数据
		Thread write = new Thread(new Runnable(){
			public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "添加数据start");
						Thread.sleep(1000);
						for (int i=0; i<1000; i++) {
							urwl.add(i + "");
						}
						System.out.println(Thread.currentThread().getName() + "添加数据end");
					} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}, "write");
		write.start();
		// 10个线程在读数据
		for (int i=0; i<10; i++) {
			new Thread(new Runnable(){
				public void run() {
					try {
//						System.out.println(new Random().nextInt(10000));
						Thread.sleep(new Random().nextInt(10000));
						System.out.println(Thread.currentThread().getName() + "读取数据start");
						urwl.iterateOnList();
						System.out.println(Thread.currentThread().getName() + "读取数据end");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "read"+i).start();
		}
	}
}
