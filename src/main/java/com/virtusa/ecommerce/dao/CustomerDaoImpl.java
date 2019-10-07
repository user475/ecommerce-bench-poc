package com.virtusa.ecommerce.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.virtusa.ecommerce.controller.CustomerController;
import com.virtusa.ecommerce.model.Customer;

@Repository
public class CustomerDaoImpl extends Dao implements CustomerDao {

	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	
	public List<Customer> findByEmailId(String emailId) {
		List<Customer> list=null;
		try {
		Query query = (Query) getSession().createQuery("from Customer c where c.emailId = :email ");
		query.setParameter("email", emailId);
		
		list = query.list();
		}
		catch(QuerySyntaxException qse) {
			throw new UsernameNotFoundException("dds");
		}
		return list;
	}

	public void saveUser(Customer Customer) {
		LOG.info("user repository"+Customer.toString());
		getSession().save(Customer);

	}

}
