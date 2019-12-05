package com.srysoft.redditDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srysoft.redditDemo.model.User;
import com.srysoft.redditDemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		
		userRepository.save(user);
		
		return user;
	}
	
	
}
