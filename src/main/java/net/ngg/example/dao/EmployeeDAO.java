package net.ngg.example.dao;

import java.util.List;

import net.ngg.example.entity.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
}
