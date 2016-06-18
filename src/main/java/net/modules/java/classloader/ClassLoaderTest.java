package net.modules.java.classloader;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Java program to demostrate How classloader works in Java, 
 * in particular about visibility priciple of ClassLoader.
 */
public class ClassLoaderTest {

	public static void main(String[] args) {
		try {
			// Some implementations may use null to represent the Bootstrap class loader.
			// This method will return null in such implementations if this class was loaded by the bootstrap class loader.
			System.out.println(String.class.getClassLoader());
			
			// printing ClassLoader of this class
			System.out.println("ClassLoaderTest.getClass().getClassLoader() : " + ClassLoaderTest.class.getClassLoader());
			
			// trying to explicitly load this class again using Extension class loader
			Class.forName("net.modules.java.classloader.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent());
		} catch (ClassNotFoundException e) {
			Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, "Class Not Found", e);
		}
	}

}
