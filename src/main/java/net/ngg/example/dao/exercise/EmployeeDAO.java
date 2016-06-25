package net.ngg.example.dao.exercise;

import java.util.List;

import net.ngg.example.entity.exercise.Employee;

public interface EmployeeDAO {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer employeeId);
	public Employee getEmployeeById(Integer employeeId);
}
