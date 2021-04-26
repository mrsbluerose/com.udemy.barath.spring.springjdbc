package com.udemy.barath.spring.springjdbc.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.udemy.barath.spring.springjdbc.employee.dao.EmployeeDao;

public class test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/udemy/barath/spring/springjdbc/employee/test/config.xml");
		EmployeeDao jdbcTemplate = (EmployeeDao) context.getBean("employeeDao");
		int result = dao.create(new Employee());
		System.out.println("Number of records inserted: " + result);
	}

}
