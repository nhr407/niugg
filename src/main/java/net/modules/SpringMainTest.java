package net.modules;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.ngg.example.service.exercise.EmployeeServiceImpl;

public class SpringMainTest {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "test");
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mvc.xml", "applicationContext-web.xml"});
		EmployeeServiceImpl a =(EmployeeServiceImpl) context.getBean("employeeServiceImpl");
	}

}
