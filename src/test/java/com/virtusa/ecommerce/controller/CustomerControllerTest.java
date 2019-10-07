package com.virtusa.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.virtusa.ecommerce.config.TestAppStartUp;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.service.CustomerService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppStartUp.class)
public class CustomerControllerTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void checkRegisteration() {
		Customer customer = customerService.findByEmailId("p@k");
		assertNotNull(customer);
		assertEquals("p@k", customer.getEmailId());
	}

	@Test
	public void checkRegisterationNagative() {
		Customer customer = customerService.findByEmailId("p@m");
		assertNull(customer);
	}

	@Test
	public void testSampleService() {
		assertEquals(56, 56);
	}
}
