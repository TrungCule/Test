package com.example.TEST;

import com.example.TEST.domain.Roles;
import com.example.TEST.domain.Users;
import com.example.TEST.repository.UserRepository;
import com.example.TEST.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;

	@Bean
	public CommandLineRunner run(UserService userService) {
		return args1 -> {

//			userService.saveUser(new Users(null, "TrungNguyen","123456a@","Trung", new ArrayList<>()));
//			userService.saveUser(new Users(null, "CongToan","123456a@","Toan", new ArrayList<>()));
//			userService.saveUser(new Users(null, "KhaiVu","123456a@","Khai", new ArrayList<>()));
//			userService.saveUser(new Users(null, "TaVan","123456a@","Van", new ArrayList<>()));
//			userService.saveUser(new Users(null, "ThiThao","123456a@","Thao", new ArrayList<>()));

//			userService.addRoleToUser("TrungNguyen","ROLE_ADMIN");
//			userService.addRoleToUser("TrungNguyen","ROLE_USER");
//			userService.addRoleToUser("CongToan","ROLE_USER");
//			userService.addRoleToUser("KhaiVu","ROLE_USER");
//			userService.addRoleToUser("TaVan","ROLE_USER");
//			userService.addRoleToUser("ThiThao","ROLE_USER");

		};
	}
}
