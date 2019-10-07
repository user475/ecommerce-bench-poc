package com.virtusa.ecommerce.dao;

import java.util.List;

import com.virtusa.ecommerce.model.Address;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.model.Orders;

public interface OrderDao {
	public Orders findByOrderId(Integer orderId);

	public Orders submitFeedback(Orders order);

	public Integer placeOrder(Integer orderId, Integer addressId);

	public void removeOrderFromCart(Integer orderId);

	public List<Orders> getListOfOrders(Integer userId, String orderStatus);
	
	public List<Address> getListOfAddress(Integer userId);
	
	public Customer addAddresstoUserId(Customer customer);
}
