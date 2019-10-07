package com.virtusa.ecommerce.controller;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.virtusa.ecommerce.config.TestAppStartUp;
import com.virtusa.ecommerce.service.OrderService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppStartUp.class)
public class OrderControllerTest {

	@Autowired
	private OrderService service;

	@Test
	public void checkListOfOrderByUserId() {
		assertNotNull(service.listOfOrderByCustomerId(3, "P"));

	}

}