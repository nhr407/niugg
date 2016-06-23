package net.modules.threadstudy.waitnotify.producerconsumer2;

public class WaitNotifyBuffer implements Buffer {
	String line;
	
	@Override
	public synchronized void send(String s) {
		if (line != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		line = s;
		notify();
	}

	@Override
	public synchronized String receive() {
		if (line == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String s = line;
		line = null;
		notify();
		return s;
	}

}
