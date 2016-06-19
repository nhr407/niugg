package net.modules.threadstudy.concurrency;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class FailfastDemo {
	public static void main(String[] args) {
		final List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		// This thread will iterate the list
		new Thread(new Runnable() {
			public void run() {
				try {
					Iterator<String> it = list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
						// Using sleep to simulate concurrency
						Thread.sleep(1000);
					}
				} catch(ConcurrentModificationException ex) {
					System.out.println("Thread1: concurrent modification detected on this list");
					ex.printStackTrace();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "thread1").start();
		
		// This thread will try to add to the collection, 
		// while the collection is iterated by another thread.
		new Thread(new Runnable(){
			public void run() {
				try {
					// Using sleep to simulate concurrency
					Thread.sleep(2000);
					// add new value to the shared list
					list.add("5");
					System.out.println("new value added to the list");
				} catch (ConcurrentModificationException e) {
					System.out.println("thread2: Concurrent modification detedted on the List");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "thread2").start();
	}
}
