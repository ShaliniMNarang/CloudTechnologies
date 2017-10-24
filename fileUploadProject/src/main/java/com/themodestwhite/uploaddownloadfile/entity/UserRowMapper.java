package com.themodestwhite.uploaddownloadfile.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet row, int rowNum) throws SQLException {
		User user = new User();
		user.setActive("Y");
		user.setFirstName(row.getString("firstname"));
		user.setLastName(row.getString("lastname"));
		user.setPassword(row.getString("password"));
		user.setUserName(row.getString("username"));
		return user;
	}

}
