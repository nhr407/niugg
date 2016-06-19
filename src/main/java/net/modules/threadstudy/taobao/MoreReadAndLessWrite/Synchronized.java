package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * 多读少写的并发问题
 * 解决方法 1. 使用完全同步
 */
public class Synchronized {
	private final List<String> list = new ArrayList<String>();
	public synchronized void iterateOnList() {
		for (String s : list) {
			// do something with s
			System.out.println(s);
		}
	}
	
	public synchronized void add(String value) {
		list.add(value);
	}
}
