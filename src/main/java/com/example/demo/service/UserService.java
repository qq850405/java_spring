package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
	void registerUser(User user);
	List<User> findUserByAccount(String account);
}
