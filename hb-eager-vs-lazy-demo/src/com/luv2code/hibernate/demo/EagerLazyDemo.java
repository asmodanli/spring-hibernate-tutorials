package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get instructor from db;
			int id_ = 1;
			Instructor tempInstructor = session.get(Instructor.class, id_);
		
 			System.out.println("POINT! instructor: " + tempInstructor); 			
			
			// commit transaction
			session.getTransaction().commit();
			
			// break it
			session.close();
			System.out.println("POINT!");
						
			// get courses for instructor
			System.out.println("POINT! courses: " + tempInstructor.getCourses());
			
			System.out.println("POINT! Done");
		}
		
		finally {
			session.close();
			factory.close();
		}
	}

}
