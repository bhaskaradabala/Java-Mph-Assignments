package com.example.sportshopee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Login {
	@Id
	private String email;
	
	private String password;
	private String role;
	
	private Boolean isLogin;
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
	@JsonBackReference
	private Customer customer;


	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Login(String email, String password, String role, Boolean isLogin, Customer customer) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.isLogin = isLogin;
		this.customer = customer;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}
	

	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + password + ", role=" + role + ", isLogin=" + isLogin
				+ ", customer=" + customer + "]";
	}


}
