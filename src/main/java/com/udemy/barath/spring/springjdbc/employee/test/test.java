package com.udemy.barath.spring.springjdbc.employee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemy.barath.spring.springjdbc.employee.Employee;
import com.udemy.barath.spring.springjdbc.employee.dao.EmployeeDao;

public class test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/udemy/barath/spring/springjdbc/employee/test/config.xml");
		EmployeeDao dao = (EmployeeDao) context.getBean("employeeDao");
		Employee employee = new Employee();
		employee.setId(2);
		employee.setFirstName("Bob");
		employee.setLastName("Smith");
		//int result = dao.create(employee);
		//int result = dao.update(employee);
		int result = dao.delete(1);
		System.out.println("Number of records affected: " + result);
	}

}
