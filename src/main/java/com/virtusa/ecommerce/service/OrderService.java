package com.virtusa.ecommerce.service;

import java.util.List;

import com.virtusa.ecommerce.model.Address;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.model.Orders;
import com.virtusa.ecommerce.model.Product;

public interface OrderService {

	public List<Orders> listOfOrderByCustomerId(Integer userId, String orderStatus);


	public String submitFeedback(Integer orderId, Float rating, String feedback);

	public void placeOrder(List<Integer> list, Integer addressId);

	public void removeOrder(Integer orderId);
	
	public List<Address> listOfAddressByCustomerId(Integer userId);


	public void addAddresstoUserId(Customer customer);
}
