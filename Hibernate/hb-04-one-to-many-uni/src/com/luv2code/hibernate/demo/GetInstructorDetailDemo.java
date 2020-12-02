package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
				
		// create session
		Session session = factory.getCurrentSession();
		
		try {


			// start a transaction
			session.beginTransaction();
			
			// get the inst. detail obj
			int id_ = 666;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id_);
			
			// print inst. detail
			System.out.println("tempInstructorDet. " + tempInstructorDetail);
			
			// print associated ins.
			System.out.println("associated inst. " + tempInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}
	}

}
