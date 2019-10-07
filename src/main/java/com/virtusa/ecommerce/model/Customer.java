package com.virtusa.ecommerce.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Customers", schema = "ecommerce-assigement")
public class Customer implements Serializable {

	private static final long serialVersionUID = 6040173572908069698L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@NotEmpty(message = "FirstName is required")
	private String firstName;
	@NotEmpty(message = "LastName is required")
	private String lastName;
	
	@Column(unique = true)
	@Email(message = "Emailid is required")
	private String emailId;
	@Length(min = 8, message = "Password should be 8 charecters")
	private String password;
	@Length(min = 10, max = 10, message = "Mobile number should have 10 digits")
	private String mobileNo;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Address> userAddress = new HashSet<Address>();
	
	public Customer() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	public Set<Address> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Set<Address> userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", password=" + password + ", mobileNo=" + mobileNo + ", userAddress=" + userAddress + "]";
	}

	/*
	 * @Override public String toString() { return "Users [userId=" + userId +
	 * ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" +
	 * emailId + ", password=" + password + ", mobileNo=" + mobileNo + "]"; }
	 */
	

}
