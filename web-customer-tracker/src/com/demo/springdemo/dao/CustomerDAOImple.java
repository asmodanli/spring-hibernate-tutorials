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
	
		// execure query 
		List<Customer> customers = theQuery.getResultList();
		
		// return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSesion = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSesion.save(theCustomer);
	}

}
