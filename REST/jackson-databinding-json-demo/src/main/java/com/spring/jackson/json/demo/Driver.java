package com.spring.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
					
			// read JSON fila map/convert to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			System.out.println("first name = " + theStudent.getFirstName());
			System.out.println("last name = " + theStudent.getLastName());

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
