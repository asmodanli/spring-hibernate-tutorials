package com.demo.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImple implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImple(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {	employeeDAO = theEmployeeDAO;
	}
	
	@Transactional
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
