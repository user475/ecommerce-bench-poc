package com.virtusa.ecommerce.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.virtusa.ecommerce.config.TestAppStartUp;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppStartUp.class)
public class ControllerMockMvcTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	final String jsonFormat = "application/json;charset=UTF-8";

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void searchResult() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/search").param("searchText", "mobile")).andExpect(status().isOk())
				.andExpect(view().name("search"));
	}

	@Test
	public void productDetails() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product/{cid}", 1)).andExpect(status().isOk())
				.andExpect(view().name("product-home"));
	}

	@Test
	public void addToCart() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product/cart").param("productId", "" + 1))
				.andExpect(status().isOk());
	}

	@Test
	public void submitFeedback() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/order/feedback").param("orderId", "1").param("feedback", "good")
				.param("ratingValue", "5")).andExpect(status().isOk());

	}

	@Test
	public void ordersHistory() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/my-orders")).andExpect(MockMvcResultMatchers.status().isOk());

	}

}
