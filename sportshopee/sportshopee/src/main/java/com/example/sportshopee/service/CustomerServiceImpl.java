package com.example.sportshopee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sportshopee.entity.Address;
import com.example.sportshopee.entity.Customer;
import com.example.sportshopee.repository.AddressRepository;
import com.example.sportshopee.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> cusObj = customerRepo.findById(customer.getUserId());
		if (cusObj.isPresent()) {
			return customerRepo.save(customer);
		} else {
			return null;
		}
	}

	@Override
	public void deleteCustomer(Long userId) {
		Optional<Customer> cusObj = customerRepo.findById(userId);
		if (cusObj.isPresent()) {
			customerRepo.deleteById(userId);
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Long userId) {
		Optional<Customer> cusObj = customerRepo.findById(userId);

		if (cusObj.isPresent()) {
			return cusObj.get();
		}
		return null;
	}

	@Override
	public Customer getCustomerByName(String name) {
		Optional<Customer> cusObj = customerRepo.getCustomerByName(name);

		if (cusObj.isPresent()) {
			return cusObj.get();
		}
		return null;
	}
	
	public Address addAddressToCustomer(Long userId, Address address) {
        Optional<Customer> customerOptional = customerRepo.findById(userId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            address.setCustomer(customer);
            return addressRepo.save(address);
        }
        return null; // Or throw an exception
    }

    public void removeAddressFromCustomer(Long userId, Long addressId) {
        Optional<Customer> customerOptional = customerRepo.findById(userId);
        if (customerOptional.isPresent()) {
            Optional<Address> addressOptional = addressRepo.findById(addressId);
            if (addressOptional.isPresent()) {
                Address address = addressOptional.get();
                if (address.getCustomer().equals(customerOptional.get())) {
                    addressRepo.delete(address);
                }
            }
        }
    }

}
