package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
						
			// display students
			displayStudents(theStudents);
			
			// query students where name
			theStudents = session.createQuery("from Student s where s.firstName = 'sena'").list();
			
			// display students
			System.out.println("sena olan öðrenciler: ");
			displayStudents(theStudents);			
			
			theStudents = session.createQuery("from Student s where s.email LIKE 's%'").list();
			
			// display students
			System.out.println("maili s ile baþlayan öðrenciler: ");
			displayStudents(theStudents);			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
