package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session obj. to save java obj.
			System.out.println("creating new student obj.");
			Student tempStudent = new Student("salih", "modanli", "salih@gmail.com");
			// start a transaction
			session.beginTransaction();
			// start a student obj.
			System.out.println("saving student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			// find out primary key
			System.out.println("id: " + tempStudent.getId());
			// get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			// retrieve student based on id
			System.out.println("getting student with id: " + tempStudent.getId() );
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("get complete: " + myStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}

}
