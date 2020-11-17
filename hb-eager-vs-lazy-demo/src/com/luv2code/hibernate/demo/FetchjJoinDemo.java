package com.luv2code.hibernate.demo;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.query.*;;

public class FetchjJoinDemo {

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
			int id_ = 5;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " + 
					"JOIN FETCH i.courses Where i.id = theInstructorId",
					Instructor.class);
		
 			query.setParameter("theInstructorId", id_);
 			
 			Instructor tempInstructor = query.getSingleResult();
 			

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
