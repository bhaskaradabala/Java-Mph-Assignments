package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empServ;

	// Add Employee
	@PostMapping("/employee/add")
	Employee addEmployee(@RequestBody Employee emp) {
		return empServ.addEmployee(emp);
	}

	// Get all Employees
	@GetMapping("/employee/all")
	List<Employee> getAllEmployees() {
		return empServ.getAllEmployees();
	}
	
	// Get Emp by name
	@GetMapping("/employee/getByName/{name}")
	Employee getEmpByName(@PathVariable String name) {
		return empServ.getEmpByName(name);
	}
}
