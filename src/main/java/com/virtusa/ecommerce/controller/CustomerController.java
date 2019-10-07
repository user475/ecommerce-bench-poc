package com.virtusa.ecommerce.controller;

import java.security.Principal;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.ecommerce.model.Customer;
import com.virtusa.ecommerce.service.CustomerService;

@Controller
public class CustomerController {
	private static final Logger LOG = Logger.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;

	@Autowired

	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/signup")
	public String signupUser(Model model) {

		model.addAttribute("customer", new Customer());
		return "signup";
	}

	@PostMapping(value = "/signup")
	public String signup(Model model, @Valid @ModelAttribute("customer") Customer customer, Errors error) {
		if (error.hasErrors()) {
			LOG.info("error count" + error.getErrorCount());
			return "signup";
		}
		Customer exists = service.findByEmailId(customer.getEmailId());

		if (exists == null) {
			LOG.info("customer controller" + customer.toString());
			String encode = passwordEncoder.encode(customer.getPassword());

			// String encode = passwordEncoder.encode(customer.getPassword());
			LOG.info("encode" + encode);
			customer.setPassword(encode);
			service.registerCustomer(customer);

			return "redirect:/login";
		} else {
			return "redirect:/login?error=user name already Exists";
		}
	}

	@GetMapping(value = "/logout")
	@ResponseBody
	public String logout() {

		return "login";

	}

	@RequestMapping(value = "/login")
	public String loginMethod(@RequestParam(value = "error", required = false) Boolean error, Principal user,
			Model model) {

		if (user != null) {
			LOG.info("user is present");
			return "redirect:/home";
		}
		if (error != null) {
			LOG.info("error is present");
			model.addAttribute("error", "Invalid username and password!");
		}

		return "login";

	}
}
