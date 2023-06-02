package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;


	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void registerUser(User user) {

		userRepository.save(user);
	}


	@Override
	public List<User> findUserByAccount(String account) {
		return userRepository.findByAccount(account);
	}





	@Override
	public void setVerifyCode(String account, String verifyCode) {
		com.example.demo.entity.User entityUser = userRepository.findByAccount(account).get(0);
		entityUser.setVerifyCode(verifyCode);
		userRepository.save(entityUser);

	}

	@Override
	public void checkVerifyCode(String account, String verifyCode) {
		com.example.demo.entity.User entityUser = userRepository.findByAccount(account).get(0);
		try {
			if (Objects.equals(verifyCode, entityUser.getVerifyCode())) {
				entityUser.setVerify("1");
				userRepository.save(entityUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
