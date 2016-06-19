package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * 多读少写的并发问题
 * 解决方法 3. Copy on Write
 */
public class CopyOnWrite {
	private volatile List<String> list = new ArrayList<String>();
	
	public void iterateOnList() {
		for(String s : list) {
			// do something with s
			System.out.println(s);
		}
	}
	
	public synchronized void add(String value) {
		List<String> copy = new ArrayList<String>(list);
		copy.add(value);
		list = copy;
	}
}
