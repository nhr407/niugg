package net.ngg.example.dao.exercise;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.Assert;
import net.ngg.example.entity.exercise.Employee;

// DAO层使用集成测试
// integration testing, 集成测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml", "classpath*:applicationContext-web.xml"})
@ActiveProfiles("test")  // Integration Testing with Environment Profiles
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class EmployeeDaoImplTest {
	@Autowired private EmployeeDAO employeeDao;
	
	@Test
	@Transactional
    @Rollback(true)
	public void testAddEmployee(){
		Employee employee = new Employee();
		employee.setEmail("nhr407@163.com");
		employee.setFirstname("牛");
		employee.setLastname("宏睿");
		employee.setTelephone("13111113333");
		employeeDao.addEmployee(employee);
		Assert.assertNotNull(employee.getId());
	}
}
