package com.virtusa.ecommerce.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtusa.ecommerce.model.Catalog;
import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.service.CatalogService;
import com.virtusa.ecommerce.service.CustomerService;

@Controller
public class CatalogController {

	@Autowired
	private CatalogService service;

	@Autowired
	private CustomerService customerService;

	private static final Logger LOG = Logger.getLogger(CatalogController.class);

	@GetMapping("/home")
	public String catlogList(Model model, HttpSession session,Locale locale) throws UsernameNotFoundException {
		LOG.info("##"+locale.getLanguage()+"lcoa;e"+locale);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (user == null)
			throw new UsernameNotFoundException("user not found");
		String email = user.getUsername();
		session.setAttribute("userName", email);
		Customer dbuser = customerService.findByEmailId(email);
		session.setAttribute("customerObj", dbuser);

		List<Catalog> catalogsList = service.getCatalogsList();
		model.addAttribute("list", catalogsList);
		//RollingFileAppender rollingFileAppender = new RollingFileAppender();
		//rollingFileAppender.file
		
		return "catalog-home";

	}

	
}
