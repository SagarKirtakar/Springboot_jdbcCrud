package com.soft.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soft.main.dao.UserDao;
import com.soft.main.entity.User;

@SpringBootApplication
public class SpringBootJdbcCrudApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User();
		u1.setName("Sagar Kirtakar");
		u1.setEmail("sagarkirtakar2002@gmail.com");
		u1.setGender("Male");
		u1.setCity("Pune");
		
		boolean status = userDao.addUserDetails(u1);
		if(status) {
			System.out.println("User successfully added.....");
		}else {
			System.out.println("User not addede due to some error..?");
		}
	}

}
 