package com.virtusa.ecommerce.dao;

import java.util.List;

import com.virtusa.ecommerce.model.Orders;
import com.virtusa.ecommerce.model.Product;

public interface ProductDao {

	public List<Product> getProductListByCatagery(Integer catId);

	public Product getProductById(Integer pid);

	public Integer addProductToCart(Orders order);

	public List<Product> searchResult(String productName);

}
