package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{
	
	
	/* Custom queries related to Structured Data
	// Optional<Employee> findByName(String name);
	 * 
	 */
	
//	  {
//		    _id: Long('1004'),
//		    data: { name: 'Suresh', age: 21 },
//		    _class: 'com.example.entity.Employee'
//		  }
	  
	  
	  
	@Query("{'data.name': ?0}")
	Employee getEmpByName(@Param("name") String name);
	

}
