package net.ngg.example.service.exercise;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.ngg.example.dao.exercise.EmployeeDAO;
import net.ngg.example.entity.exercise.Employee;

// Service层使用Unit Test（Mock测试）
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	@Mock
	private Employee employee;
	@Mock 
	private EmployeeDAO employeeDao;
	@InjectMocks  // 被测试的对象
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Before
	public void setUp(){
		employeeServiceImpl = new EmployeeServiceImpl();
	}
	
	@Test
	public void testGetAllEmployees() {
		assertNotNull(employee);
		assertNotNull(employeeDao);
		
	}
}
