package net.modules.java.properties;

import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.list(System.out);
	}

}
