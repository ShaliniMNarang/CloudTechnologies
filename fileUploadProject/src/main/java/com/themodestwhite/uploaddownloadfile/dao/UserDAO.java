package com.themodestwhite.uploaddownloadfile.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.themodestwhite.uploaddownloadfile.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class UserDAO implements IUserDAO{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	

	@Override
	public User getUserDetails(String userName, String password) {
		String sql = "select username, firstname, lastname from user where username=? and password=?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, userName, password);
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
