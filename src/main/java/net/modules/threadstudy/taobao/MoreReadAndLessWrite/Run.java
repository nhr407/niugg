package net.modules.threadstudy.taobao.MoreReadAndLessWrite;

public class Run {

	public static void main(String[] args) {
		UsingReadWriteLock urwl = new UsingReadWriteLock();
		// TODO ...
	}
	
	// 用于加数
	class MyWriteThread implements Runnable {
		private UsingReadWriteLock urwl;
		
		MyWriteThread(UsingReadWriteLock urwl) {
			this.urwl = urwl;
		}
		
		public void run() {
			for (int i=0; i<1000; i++) {
				urwl.add(String.valueOf(i));
			}
		}
	}
	
	// 用于遍历
	class MyReadThread implements Runnable {
		private UsingReadWriteLock urwl;
		
		MyReadThread(UsingReadWriteLock urwl) {
			this.urwl = urwl;
		}
		
		public void run() {
			urwl.iterateOnList();
		}
	}

}
