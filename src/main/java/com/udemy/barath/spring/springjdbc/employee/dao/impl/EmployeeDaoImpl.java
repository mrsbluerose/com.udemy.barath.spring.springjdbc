package com.udemy.barath.spring.springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.udemy.barath.spring.springjdbc.employee.Employee;
import com.udemy.barath.spring.springjdbc.employee.dao.EmployeeDao;
import com.udemy.barath.spring.springjdbc.employee.dao.rowmapper.EmployeeRowMapper;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
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

	@Override
	public Employee read(int id) {
		String sql = "SELECT * FROM employee WHERE id=?";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);

		return employee;
	}
	
	@Override
	public List<Employee> find() {
		String sql = "SELECT * FROM employee";
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		List<Employee> result = jdbcTemplate.query(sql, rowMapper);		
		return result;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}




}
