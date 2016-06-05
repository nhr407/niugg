package net.modules.utils;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
	private ArrayList<String> lst;   // Test fixtures
	   
	   // Initialize test fixtures before each test method
	   @Before  
	   public void init() throws Exception {
	      lst = new ArrayList<String>();
	      lst.add("alpha");    // at index 0
	      lst.add("beta");     // at index 1
	   }
	   
	   // Test method to test the insert operation
	   @Test   
	   public void insertTest() {
	      // assertEquals(String message, long expected, long actual)
	      Assert.assertEquals("wrong size", 2, lst.size());
	      lst.add(1, "charlie");
	      Assert.assertEquals("wrong size", 3, lst.size());
	      // assertEquals(String message, Object expected, Object actual)
	      // Use String.equals() for comparison
	      Assert.assertEquals("wrong element", "alpha",   lst.get(0));
	      Assert.assertEquals("wrong element", "charlie", lst.get(1));
	      Assert.assertEquals("wrong element", "beta",    lst.get(2));
	   }
	   
	   // Test method to test the replace operation
	   @Test   
	   public void replaceTest() {
	      Assert.assertEquals("wrong size", 2, lst.size());
	      lst.set(1, "charlie");
	      Assert.assertEquals("wrong size", 2, lst.size());
	      Assert.assertEquals("wrong element", "alpha",   lst.get(0));
	      Assert.assertEquals("wrong element", "charlie", lst.get(1));
	   }
}
