package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
		
			// create some courses
			Course course_1 = new Course("android");
			Course course_2 = new Course("html");
			
			// add courses to instructor
			tempInstructor.add(course_1);
			tempInstructor.add(course_2);
			
			// save the courses
			session.save(course_1);
			session.save(course_2);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		
		finally {
			session.close();
			factory.close();
		}
	}

}
