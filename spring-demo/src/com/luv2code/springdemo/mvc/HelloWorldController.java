package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// add data to model
	@RequestMapping("/processFormVersionTwo")
	public String shoutDude(HttpServletRequest request, Model model) {
		
		// read req. parameter from html
		String theName = request.getParameter("studentName"); 
		
		// convert data
		theName = theName.toUpperCase();
		
		// create message
		String result = theName + " cmooon";
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
		
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,
			Model model) {
		
		// convert data
		theName = theName.toUpperCase();
		
		// create message
		String result = theName + " vers 3";
		
		// add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}


