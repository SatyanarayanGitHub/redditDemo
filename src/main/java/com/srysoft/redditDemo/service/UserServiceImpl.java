package com.srysoft.redditDemo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srysoft.redditDemo.model.User;
import com.srysoft.redditDemo.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = false)
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUsers(User... users) {
		for (User user : users) {
			logger.info("Saving User: " + user.getEmail());
			userRepository.save(user);
		}
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
