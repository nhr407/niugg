package net.ngg.example.dao.exercise;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ngg.example.entity.exercise.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) this.sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if(null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
		}
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = (Employee) this.sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		return employee;
	}

}
