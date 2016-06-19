package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多读少写的并发问题
 * 解决方法 2. 使用读写锁
 */
public class UsingReadWriteLock {
	private final List<String> list = new ArrayList<String>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void iterateOnList() {
		lock.readLock().lock();
		try {
			for(String s : list) {
				// do something with s
				System.out.println(s);
			}
		}finally {
			lock.readLock().unlock();
		}
	}
	
	public synchronized void add(String value) {
		lock.writeLock().lock();
		try {
			list.add(value);
		}finally{
			lock.writeLock().unlock();
		}
	}
}
