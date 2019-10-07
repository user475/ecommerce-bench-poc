package com.virtusa.ecommerce.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.ecommerce.dao.ProductDao;
import com.virtusa.ecommerce.model.Orders;
import com.virtusa.ecommerce.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	@Autowired
	private ApplicationContext context;
	@Autowired
	private Orders order1;

	@Override
	public List<Product> getProductListByCatagery(Integer catId) {

		return dao.getProductListByCatagery(catId);
	}

	@Override
	public Product getProductById(Integer pid) {
		Product product = dao.getProductById(pid);
		return product;
	}

	@Override
	public Integer addProductToCart(Integer pid, Integer userId) {
		System.out.println("@@@@@@@@@:"+order1.getOrderId());
		Orders order = context.getBean(Orders.class);
		order.setUserId(userId);
		order.setProductId(pid);
		Product product = getProductById(pid);
		order.setProductName(product.getProductName());
		order.setProductDescrption(product.getProductDescrption());
		order.setOrderPrice(product.getPrice());
		order.setDate(new Date());
		order.setOrderStatus("P");
		Integer addProductToCart = dao.addProductToCart(order);
		return addProductToCart;

	}

	@Override
	public List<Product> searchResult(String productName) {
		return dao.searchResult(productName);

	}

}
