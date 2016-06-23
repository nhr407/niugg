package net.modules.threadstudy.waitnotify.producerconsumer2;

public interface Buffer {
	
	public void send(String s);
	public String receive();
	
}
