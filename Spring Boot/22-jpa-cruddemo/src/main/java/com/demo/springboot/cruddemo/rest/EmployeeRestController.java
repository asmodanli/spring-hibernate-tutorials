package com.demo.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.cruddemo.dao.EmployeeDAO;
import com.demo.springboot.cruddemo.entity.Employee;
import com.demo.springboot.cruddemo.service.EmployeeService;

@RequestMapping("/api")
@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;

	// inject employee service
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService; // constructor injection
	}

	// expose /employees and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employees/employeeId
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found " + employeeId);
		}
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0); // force to save a new item instead of update
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		
		// throw exception if null
		if(tempEmployee == null) {
			throw new RuntimeException("id not found" + employeeId);
		}

		employeeService.deleteById(employeeId);
		return "deleted employee: " + employeeId;
	}
	
	
	
}














