package com.udemy.barath.spring.springjdbc.employee.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.udemy.barath.spring.springjdbc.employee.Employee;
import com.udemy.barath.spring.springjdbc.employee.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {
		String sql="INSERT INTO employee VALUES(?,?,?)";

		int result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());
		return result;
	}
	
	@Override
	public int update(Employee employee) {
		String sql = "UPDATE employee SET firstname=?, lastname=? WHERE id=?";
		int result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());
		return result;
	}
	
	@Override
	public int delete(int id) {
		String sql = "DELETE FROM employee WHERE id=?";
		int result = jdbcTemplate.update(sql, id);
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
