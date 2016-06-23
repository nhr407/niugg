package net.modules.threadstudy.waitnotify.producerconsumer2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Consumer extends Thread {
	private BufferedWriter writer;
	Buffer buffer;
	
	public Consumer(Buffer buffer) {
		writer = new BufferedWriter(new OutputStreamWriter(System.out));
		this.buffer = buffer;
	}
	
	public String receive() {
		return buffer.receive();
	}
	
	public void run() {
		while(true) {
			String line = receive();
			if(line != null) {
				try {
					writer.write(line);
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
 }
