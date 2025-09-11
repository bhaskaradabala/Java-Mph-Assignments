package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee emp);

	List<Employee> getAllEmployees();

	Employee getEmpByName(String name);

}
