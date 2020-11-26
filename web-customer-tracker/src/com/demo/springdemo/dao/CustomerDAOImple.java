package com.demo.springdemo.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.springdemo.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@Repository
public class CustomerDAOImple implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create query - sort by lastname
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", 
										Customer.class);
	
		// execute query 
		List<Customer> customers = theQuery.getResultList();
		
		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSesion = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSesion.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int id_) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// retrieve/read from db using primary key
		Customer theCustomer = currentSession.get(Customer.class, id_);
		
		return theCustomer;
	}

}
