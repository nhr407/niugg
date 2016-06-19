package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

import java.util.Random;

public class Run {

	public static void main(String[] args) {
		final UsingReadWriteLock urwl = new UsingReadWriteLock();
		// 1个线程在写数据
		Thread write = new Thread(new Runnable(){
			public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "添加数据start");
						for (int i=0; i<1000; i++) {
							Thread.sleep(i);
							urwl.add(i + "");
						}
						System.out.println(Thread.currentThread().getName() + "添加数据end");
					} catch (InterruptedException e) {
						e.printStackTrace();
				}
			}
		}, "writeThread");
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
			}, "readThread"+i).start();
		}
	}
}
