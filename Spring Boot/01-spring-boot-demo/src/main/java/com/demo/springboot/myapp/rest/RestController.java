package com.demo.springboot.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	// expose "/" return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World time on server is " + LocalDateTime.now();
	}
}
