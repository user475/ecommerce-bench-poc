package com.virtusa.ecommerce.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalog", schema = "ecommerce-assigement")
public class Catalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	
	private String catalogName;

	@OneToMany(fetch=FetchType.EAGER)
	private Set<Product> setProducts = new HashSet<Product>();
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	

	public Set<Product> getSetProducts() {
		return setProducts;
	}

	public void setSetProducts(Set<Product> setProducts) {
		this.setProducts = setProducts;
	}
	
	
	@Override
	public String toString() {
		return "Catalog [cid=" + cid + ", catalogName=" + catalogName + "]";
	}

}
