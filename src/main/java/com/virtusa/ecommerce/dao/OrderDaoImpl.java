package com.virtusa.ecommerce.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.virtusa.ecommerce.model.Address;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.model.Orders;

@Repository
public class OrderDaoImpl extends Dao implements OrderDao {

	private static final Logger LOG = Logger.getLogger(OrderDaoImpl.class);

	@Override
	public List<Orders> getListOfOrders(Integer userId, String orderStatus) {
		Criteria criteria = getSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("orderStatus", orderStatus));
		List<Orders> list = criteria.list();
		return list;

	}

	@Override
	public Orders findByOrderId(Integer orderId) {

		Orders order = getSession().get(Orders.class, orderId);

		LOG.info("order" + order.toString());
		return order;

	}

	@Override
	public Orders submitFeedback(Orders order) {
		getSession().save(order);
		return order;

	}

	@Override
	public Integer placeOrder(Integer orderId, Integer addressId) {
		LOG.info("placeOrder orderId" + orderId);
		Orders order = getSession().load(Orders.class, orderId);
		order.setAddressId(addressId);
		order.setOrderStatus("S");
		getSession().save(order);
		return order.getOrderId();
	}

	@Override
	public void removeOrderFromCart(Integer orderId) {
		Orders order = getSession().load(Orders.class, orderId);
		getSession().delete(order);
	}

	@Override
	public List<Address> getListOfAddress(Integer userId) {
		Criteria criteria = getSession().createCriteria(Address.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<Address> addressList = criteria.list();
		return addressList;
	}
	@Override   
	public Customer addAddresstoUserId(Customer customer) {
        getSession().saveOrUpdate(customer);
        return customer;
    }
}
