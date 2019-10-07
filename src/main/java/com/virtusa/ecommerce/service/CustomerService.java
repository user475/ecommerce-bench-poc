package com.virtusa.ecommerce.service;

import com.virtusa.ecommerce.model.Customer;

public interface CustomerService {
	Customer findByEmailId(String emailId);

	void registerCustomer(Customer customer);

}
