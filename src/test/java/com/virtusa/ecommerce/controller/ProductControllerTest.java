package com.virtusa.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.virtusa.ecommerce.config.TestAppStartUp;
import com.virtusa.ecommerce.model.Product;
import com.virtusa.ecommerce.service.ProductService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppStartUp.class)
public class ProductControllerTest {

	@Autowired
	private ProductService service;

	@Test
	public void checkProductListByCatagery() {
		assertNotNull(service.getProductListByCatagery(2));

	}

	@Test
	public void checkCatalogsList() {
		Product product = service.getProductById(101);
		assertNotNull(product);
		assertEquals("digital watch", product.getProductDescrption());

	}

	@Test
	public void checkSearchResult() {
		List<Product> productList = service.searchResult("watch");
		assertNotNull(productList);

	}

}