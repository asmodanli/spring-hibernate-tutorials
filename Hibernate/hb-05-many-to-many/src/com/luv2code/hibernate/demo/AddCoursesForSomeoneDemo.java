package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForSomeoneDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
							.	buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();

			// get selected student from db
			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("student loaded: " + tempStudent);
			System.out.println("courses: " + tempStudent.getCourses());

			// create more courses
			Course course_1 = new Course("Java Course");
			Course course_2 = new Course("C# Course");
			
			// add student to courses
			course_1.addStudent(tempStudent);
			course_2.addStudent(tempStudent);
			
			// save courses
			System.out.println("save courses");
			
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
