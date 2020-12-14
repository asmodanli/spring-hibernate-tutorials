package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for get
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	// add mapping for GET/customers/customerID
	@GetMapping("customers/{customerId}")
	public Customer  getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null) {
			throw new CustomerNotFoundException("customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	// add mapping for POST / customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) { // get json data as pojo
		
		theCustomer.setId(0); // 0 makes create new id(insert) 
		customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	// add mapping for put /customers update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	// add mapping for delete/customers/customerId - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer == null) {
			throw new CustomerNotFoundException("customer id not found - " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted customerid " + customerId;
	} 
}























