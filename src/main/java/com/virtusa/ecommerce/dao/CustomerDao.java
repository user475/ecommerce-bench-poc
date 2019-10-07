package com.virtusa.ecommerce.dao;

import java.util.List;

import com.virtusa.ecommerce.model.Customer;

public interface CustomerDao{

	List<Customer> findByEmailId(String emailId);

	void saveUser(Customer customer);
}
