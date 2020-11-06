package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id
			//System.out.println("getting student with id: " + studentId );
			//Student myStudent = session.get(Student.class, studentId);
			
			// delete student
			//System.out.println("deleting student" + myStudent);
			//session.delete(myStudent);

			
			// new code
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		
		finally {
			factory.close();
		}
	}

}