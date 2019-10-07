package com.virtusa.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.ecommerce.dao.CatalogDao;
import com.virtusa.ecommerce.dao.CustomerDao;
import com.virtusa.ecommerce.model.Catalog;
import com.virtusa.ecommerce.model.Customer;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	private CatalogDao dao;
	
	public List<Catalog> getCatalogsList() {
		
		return dao.getCatalogsList();
	}

	

}
