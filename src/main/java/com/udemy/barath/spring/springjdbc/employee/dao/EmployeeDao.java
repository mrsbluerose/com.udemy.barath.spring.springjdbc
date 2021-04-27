package com.udemy.barath.spring.springjdbc.employee.dao;

import com.udemy.barath.spring.springjdbc.employee.Employee;

public interface EmployeeDao {

	int create(Employee employee);
	int update(Employee employee);
	int delete(int id);
}
