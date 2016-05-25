package net.ngg.example.service;

import java.util.List;

import net.ngg.example.entity.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
