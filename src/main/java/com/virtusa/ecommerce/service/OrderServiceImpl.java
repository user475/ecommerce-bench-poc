package com.virtusa.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.ecommerce.dao.OrderDao;
import com.virtusa.ecommerce.model.Address;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.model.Orders;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao dao;
	@Autowired
	private ApplicationContext context;

	@Override
	public List<Orders> listOfOrderByCustomerId(Integer userId, String orderStatus) {
		return dao.getListOfOrders(userId, orderStatus);
	}

	@Override
	public String submitFeedback(Integer orderId, Float rating, String feedback) {
		Orders order = dao.findByOrderId(orderId);
		if (rating != null)
			order.setRating(rating);
		order.setFeedback(feedback);
		Orders dbOrder = dao.submitFeedback(order);
		if(dbOrder.getFeedback() == null)
			return "Fail" ;
		return "Success";
	}

	@Override
	public void placeOrder(List<Integer> list, Integer addressId) {
		list.forEach(orderId -> {
			dao.placeOrder(orderId, addressId);
		});
	}

	@Override
	public void removeOrder(Integer orderId) {
		dao.removeOrderFromCart(orderId);

	}

	public List<Address> listOfAddressByCustomerId(Integer userId) {
		return dao.getListOfAddress(userId);
	}

	@Override
	public void addAddresstoUserId(Customer customer) {
		Customer dbCustomer = dao.addAddresstoUserId(customer);
	}

}
