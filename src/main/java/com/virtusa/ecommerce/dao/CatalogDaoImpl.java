package com.virtusa.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.ecommerce.model.Catalog;
import com.virtusa.ecommerce.model.Customer;

@Repository
public class CatalogDaoImpl extends Dao  implements CatalogDao{


	public List<Catalog> getCatalogsList() {
		Query query = (Query) getSession().createQuery("from Catalog");
		List<Catalog> list = query.list();
		return list;
	}

	
}
