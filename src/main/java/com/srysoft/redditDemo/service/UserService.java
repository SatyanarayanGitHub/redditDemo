package com.srysoft.redditDemo.service;

import java.util.Optional;

import com.srysoft.redditDemo.model.User;

public interface UserService {

	public User register(User user);

	public User saveUser(User user);

	public void saveUsers(User... users);

	public Optional<User> findById(Long id);

	public Optional<User> findByEmail(String email);
}
