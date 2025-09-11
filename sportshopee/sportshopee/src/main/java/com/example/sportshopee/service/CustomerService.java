package com.example.sportshopee.service;

import java.util.List;

import com.example.sportshopee.entity.Address;
import com.example.sportshopee.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	void deleteCustomer(Long userId);	
	List<Customer> getAllCustomers();
	
	Customer getCustomerById(Long userId);
	Customer getCustomerByName(String name);
	
	Address addAddressToCustomer(Long customerId, Address address);
	void removeAddressFromCustomer(Long customerId, Long addressId);

}
