package com.virtusa.ecommerce.service;

import java.util.List;

import com.virtusa.ecommerce.model.Product;

public interface ProductService {
	public List<Product> getProductListByCatagery(Integer catId);

	public Product getProductById(Integer pid);

	public Integer addProductToCart(Integer pid, Integer userId);

	public List<Product> searchResult(String productName);

}
