package com.spring.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
					
			// read JSON fila map/convert to Java POJO
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println("first name = " + theStudent.getFirstName());
			System.out.println("last name = " + theStudent.getLastName());
			Address tempAddress = theStudent.getAddress();
			System.out.println("street = " + tempAddress.getStreet());
			
			for(String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
