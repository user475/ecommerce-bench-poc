package com.virtusa.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.virtusa.ecommerce.model.Customer;

@Service

public class CustomCustDetailsService implements UserDetailsService {

	@Autowired
	private CustomerService service;

	@Override
	public UserDetails loadUserByUsername(String emailId) {

		Customer customer = service.findByEmailId(emailId);
		String pass=customer.getPassword();
		
		if (customer == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		// session.setAttribute("prasanth", "12345");
		return new User(customer.getEmailId(), pass, true, true, true, true, authorities);

	}
}