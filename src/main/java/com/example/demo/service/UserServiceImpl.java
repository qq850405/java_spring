package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void registerUser(User user) {

		System.out.println(this.userRepository.findByAccount("merryday"));
		userRepository.save(user);
//merryday
	}

	@Override
	public List<User> findUserByAccount(String account) {
		return userRepository.findByAccount(account);
	}
}
