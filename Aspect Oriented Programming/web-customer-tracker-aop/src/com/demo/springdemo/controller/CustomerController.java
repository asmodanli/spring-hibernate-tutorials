package com.demo.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springdemo.dao.CustomerDAO;
import com.demo.springdemo.entity.Customer;
import com.demo.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add customers to model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save customer
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
				
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id_) {
		
		// delete customer
		customerService.deleteCustomer(id_);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") 
		String theSearchName, Model theModel) {
		
		// search customer from service
		List<Customer> theCustomers = customerService.searchCustomer(theSearchName);
		
		// add customers to model
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
		
		
	}
}
















