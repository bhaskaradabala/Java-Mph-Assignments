package com.example.sportshopee.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.example.sportshopee.entity.Customer;

@SpringBootTest
public class CustomerServiceImplTest {
	
	@Autowired
	private CustomerService customerServ;
	
	
	@Test
	void addCustomerTest() {
		Customer cus = new Customer();
		  cus.setName("sriram");
	      cus.setEmail("sriram@example.com");
	      cus.setContactNo("9876543210");
	      cus.setDob("03-12-2002");
	      
	      Customer saved = customerServ.addCustomer(cus);
	      assertNotNull(saved);
	      assertEquals("sriram", saved.getName());
		
	}
	@Test
    void testGetAllCustomers() {
        List<Customer> customers = customerServ.getAllCustomers();
        assertNotNull(customers);
        assertTrue(customers.size() > 0);
    }
//	@Test
//	void test4() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void test2() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void test1() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	void test3() {
//		fail("Not yet implemented");
//	}
	
	

}
