package com.virtusa.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.ecommerce.dao.CustomerDao;
import com.virtusa.ecommerce.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	public Customer findByEmailId(String emailId) {
		List<Customer> list = dao.findByEmailId(emailId);
		Customer customer = null;
		if (list.size() > 0) {
			customer = list.get(0);
			System.out.println("customer list size" + list.size());
		}
		return customer;
	}

	public void registerCustomer(Customer customer) {
		dao.saveUser(customer);
	}

}
