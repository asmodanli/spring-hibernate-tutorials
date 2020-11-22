package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseandReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// create course
			Course tempCourse = new Course("java");
			
			// add reviews
			tempCourse.addReview(new Review("+ rep"));
			tempCourse.addReview(new Review("nicee"));
			tempCourse.addReview(new Review("begenmedim"));

			System.out.println("save course");
			System.out.println(tempCourse.getReviews());
			
			// save course
			session.save(tempCourse);
			

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
