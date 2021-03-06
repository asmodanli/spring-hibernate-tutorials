package com.demo.springdemo.service;

import java.util.List;


import com.demo.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int id_);

	public void deleteCustomer(int id_);

	public List<Customer> searchCustomer(String theSearchName);
}
