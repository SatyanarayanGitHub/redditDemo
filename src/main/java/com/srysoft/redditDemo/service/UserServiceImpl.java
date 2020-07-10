package com.srysoft.redditDemo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	private final RoleService roleService;

	private final BCryptPasswordEncoder encoder;

	public UserServiceImpl(RoleService roleService) {
		this.roleService = roleService;
		encoder = new BCryptPasswordEncoder();
	}

	@Override
	@Transactional(readOnly = false)
	public User register(User user) {
		// TODO 1. take the password from the form and encode
		String secret = "{bcrypt}" + encoder.encode(user.getPassword());
		user.setPassword(secret);

		// TODO 2. assign a role to this user
		user.addRole(roleService.findByName("ROLE_USER"));

		// TODO 3. set an activation code

		// TODO 4. disable the user

		// TODO 5. save the user
		saveUser(user);

		// TODO 6. send the activation email

		return userRepository.save(user);
	}

	@Override
	@Transactional(readOnly = false)
	public User saveUser(User user) {
		return userRepository.save(user);
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

	public void sendActivationEmail(User user) {
		// TODO - send Activation Email code ...
	}

}
