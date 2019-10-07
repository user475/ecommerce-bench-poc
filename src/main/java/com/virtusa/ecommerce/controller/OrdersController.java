package com.virtusa.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.ecommerce.model.Address;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.model.Orders;
import com.virtusa.ecommerce.service.OrderService;

@Controller
public class OrdersController {

	private static final Logger LOG = Logger.getLogger(OrdersController.class);

	@Autowired
	private OrderService service;
	@Autowired
	private ApplicationContext context;

	@GetMapping("/cart")
	public String listOfOrdersInCart(HttpSession session, Model model) {
		Customer customer = (Customer) session.getAttribute("customerObj");
		List<Orders> listOfOrderByCustomerId = service.listOfOrderByCustomerId(customer.getUserId(), "P");
		LOG.info("customer.getUserAddress() in session" + customer.getUserAddress().size());
		List<Address> listOfAddressByCustomerId = new ArrayList<Address>(customer.getUserAddress());
		model.addAttribute("orderList", listOfOrderByCustomerId);
		model.addAttribute("addressList", listOfAddressByCustomerId);
		model.addAttribute("orderHistory", false);
		return "cart";
	}

	@PostMapping("/order/buy-now")
	@ResponseBody
	public String placeOrder(@RequestParam(value = "orderIdList[]", required = false) List<Integer> orderIdList,
			@RequestParam("addressId") Integer addressId) {

		LOG.info("placeOrder" + orderIdList.size());
		LOG.info("addressId in  placeOrder controller" + addressId);
		orderIdList.forEach(System.out::println);
		service.placeOrder(orderIdList, addressId);
		return "success";
	}

	@GetMapping("order/cancel")
	@ResponseBody
	public String removeOrder(@RequestParam("orderId") Integer orderId) {
		service.removeOrder(orderId);
		return "success";
	}

	@GetMapping("/my-orders")
	public String ordersHistory(HttpSession session, Model model) {
		Customer user = (Customer) session.getAttribute("customerObj");
		List<Orders> listOfOrderByUserId = service.listOfOrderByCustomerId(user.getUserId(), "S");
		listOfOrderByUserId.forEach(t -> LOG.info("listOfPrOrders " + t.toString()));
		model.addAttribute("orderList", listOfOrderByUserId);
		model.addAttribute("orderHistory", true);
		return "cart";
	}

	@GetMapping("/order/feedback")
	@ResponseBody
	public String submitFeedback(@RequestParam("orderId") Integer orderId,
			@RequestParam(value = "ratingValue", required = false) Float rating, @RequestParam("feedback") String feedback) {
		LOG.info("orderId" + orderId + "rating" + rating + "feedBack" + feedback);
		String result = service.submitFeedback(orderId, rating, feedback);
		return result;
	}

	@GetMapping("/address")
	public String addAddress(HttpSession session, Address addresses, Model model) {
		Customer customer = (Customer) session.getAttribute("customerObj");
		model.addAttribute("addresses", addresses);

		List<Address> addressList = new ArrayList<>(customer.getUserAddress());
		model.addAttribute("addressList", addressList);

		return "address";

	}

	@PostMapping("/address")
	public String addAddressPost(HttpSession session, @ModelAttribute("addresses") Address addresses, Model model) {
		Customer customer = (Customer) session.getAttribute("customerObj");
		Set<Address> addressList = customer.getUserAddress();
		addressList.add(addresses);
		customer.setUserAddress(addressList);
		service.addAddresstoUserId(customer);

		// return addressId;
		return "redirect:/cart";

	}

}