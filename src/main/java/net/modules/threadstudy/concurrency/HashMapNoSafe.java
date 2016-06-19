package net.modules.threadstudy.concurrency;

import java.util.HashMap;
import java.util.UUID;
/**
 * HashMap死循环
 * 多线程环境下，使用HashMap的put操作可能会引起死循环，造成CPU利用率接近100%
 * 是因为多线程会导致HashMap的Entry链表形成环形数据结构，一旦形成环形数据结构，
 * Entry的next节点永远不为空，就会产生死循环获取Entry
 * 《Java并发编程的艺术》
 *
 */
public class HashMapNoSafe {

	public static void main(String[] args) throws InterruptedException {
		final HashMap<String, String> map = new HashMap<String, String>(2);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i < 10000; i++){
					new Thread(new Runnable(){
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();;
				}
			}
		}, "ftf");
		t.start();
		t.join();
	}
}
