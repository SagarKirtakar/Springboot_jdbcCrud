package com.soft.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soft.main.entity.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTeplate;
	
	public boolean addUserDetails(User user) {
		boolean status = false;
		try {
			
			String Insert_Query = "Insert into users(name, email,gender,city) VALUES(?,?,?,?)";
			int count = jdbcTeplate.update(Insert_Query, user.getName(), user.getEmail(), user.getGender(), user.getCity());
			if(count > 0) {
				status = true;
			}else {
				status = false;
			}
			
		}catch(Exception e) {
			status = false;
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return status;
	}
}
