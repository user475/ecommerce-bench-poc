package com.virtusa.ecommerce.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.virtusa.ecommerce.controller.CustomerController;
import com.virtusa.ecommerce.model.Orders;
import com.virtusa.ecommerce.model.Product;

@Repository
public class ProductDaoImpl extends Dao implements ProductDao {

	private static final Logger LOG = Logger.getLogger(CustomerController.class);
	@Override
	public List<Product> getProductListByCatagery(Integer catId) {
		Query query = (Query) getSession().createQuery("from Product p where p.catId =:catId");
		query.setParameter("catId", catId);
		List<Product> list = query.list();
		return list;
	}
	@Override
	public Product getProductById(Integer pid) {
		Query query = (Query) getSession().createQuery("from Product p where p.pid =:productId");
		query.setParameter("productId", pid);
		Product product = (Product) query.uniqueResult();
		return product;
	}
	@Override
	public Integer addProductToCart(Orders order) {
		LOG.info("user repository" + order.toString());
		getSession().save(order);
		
		return order.getOrderId();
	}
	@Override
	public List<Product> searchResult(String productName) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.like("productName", productName,MatchMode.ANYWHERE));
		List<Product> list = criteria.list();

		return list;
	}

}
