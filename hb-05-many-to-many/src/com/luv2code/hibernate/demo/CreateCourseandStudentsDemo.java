package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseandStudentsDemo {

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

			// create course
			Course tempCourse = new Course("java");
			
			// save course
			System.out.println("save course");
			session.save(tempCourse);
			System.out.println("saving course " + tempCourse);
			
			// create students
			Student student_1 = new Student("sena", "modanli", "sena@gmail.com");
			Student student_2 = new Student("ayse", "modanli", "ayse@gmail.com");
			
			// add students to course
			tempCourse.addStudent(student_2);
			tempCourse.addStudent(student_1);
			
			// save students
			System.out.println("saving students");
			session.save(student_1);
			session.save(student_2);
			System.out.println("students: " + tempCourse.getStudents());

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
