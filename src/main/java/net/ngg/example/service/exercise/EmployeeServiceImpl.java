package net.ngg.example.service.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ngg.example.dao.exercise.EmployeeDAO;
import net.ngg.example.entity.exercise.Employee;
import net.ngg.example.service.alert.MailSendService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired 
	private MailSendService mailSendService;
	
	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
		
		// 发送异步消息(注意，此处无法保证消息发送一致性)
//		mailSendService.sendMail(employee);
		
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	@Transactional
	public Employee getEmployee(Integer employeeId) {
		return employeeDAO.getEmployeeById(employeeId);
	}

}
