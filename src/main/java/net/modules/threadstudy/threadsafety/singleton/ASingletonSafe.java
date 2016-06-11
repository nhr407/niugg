package net.modules.threadstudy.threadsafety.singleton;

/**
 * 线程安全的单例模式
 */

public class ASingletonSafe {
	private static ASingletonSafe instance = null;
	private static Object mutex = new Object();
	private ASingletonSafe(){}
	public static ASingletonSafe getInstance() {
		if(instance==null){
            synchronized (mutex){
                if(instance==null) instance= new ASingletonSafe();
            }
        }
        return instance;
	}
}
