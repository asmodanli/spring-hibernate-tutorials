package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session obj. to save java obj.
			System.out.println("creating new student obj.");
			Student tempStudent = new Student("sena", "modanli", "sena@gmail.com");
			// start a transaction
			session.beginTransaction();
			// start a student obj.
			System.out.println("saving student");
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}

}
