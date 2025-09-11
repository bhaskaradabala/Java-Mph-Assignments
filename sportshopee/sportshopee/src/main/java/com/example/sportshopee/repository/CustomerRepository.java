package com.example.sportshopee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.sportshopee.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	    //Optional<Customer> findByName(String name);
	
	
		// Native Query
		//@NativeQuery("select * from customer where name=:name")
		//Optional<Customer> getCustomerByName(@Param("name") String name);
		
		
		// JPQL Query
		@Query("select e from Customer e where e.name=:name")
		Optional<Customer> getCustomerByName(@Param("name") String name);

}
