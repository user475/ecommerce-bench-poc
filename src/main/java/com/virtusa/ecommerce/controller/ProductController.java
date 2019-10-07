package com.virtusa.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.ecommerce.model.Product;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.service.ProductService;

@Controller
public class ProductController {

	private static final Logger LOG = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService service;
	@Autowired
	private ApplicationContext context;

	@GetMapping("/product/{cid}")
	public String productDetails(Model model, @PathVariable("cid") Integer cId, HttpSession session) {
		
		List<Product> catalogsList = service.getProductListByCatagery(cId);
		model.addAttribute("list", catalogsList);
		return "product-home";

	}

	@GetMapping("/product/cart")
	@ResponseBody
	public String addToCart(@RequestParam(name = "productId", required = false) Integer productId,
			HttpSession session) {
		Customer user = (Customer) session.getAttribute("customerObj");
		Integer userId = user.getUserId();
		
		Integer orderId = service.addProductToCart(productId, userId);
		
		return "" + (orderId == null ? 0 : orderId);

	}

	@PostMapping("/search")
	public String searchResult(@RequestParam("searchText") String searchText, Model model) {
		List<Product> listOfProducts = service.searchResult(searchText);
		listOfProducts.forEach(p -> LOG.info(" search product" + p.toString()));
		model.addAttribute("list", listOfProducts);

		return "search";
	}

}