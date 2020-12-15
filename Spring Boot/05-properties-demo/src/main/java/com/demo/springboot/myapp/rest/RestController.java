package com.demo.springboot.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "coach: " + coachName + " team: " + teamName;
	}
	
	// expose "/" return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World time on server is " + LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("workout")
	public String getDailyWorkout() {
		return "run fast";
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("fortune")
	public String getDailyFortune() {
		return "you will die";
	}
	
}




















