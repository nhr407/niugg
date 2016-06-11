package net.modules.threadstudy.threadsafety.singleton;

// http://www.journaldev.com/171/thread-safety-in-java-singleton-classes-with-example-code
/**
 * 线程不安全的单例模式
 */
public class ASingletonUnsafe {
	private static ASingletonUnsafe instance = null;
	private ASingletonUnsafe(){}
	public static ASingletonUnsafe getInstance() {
		if(instance == null) {
			instance = new ASingletonUnsafe();
		}
		return instance;
	}
}
