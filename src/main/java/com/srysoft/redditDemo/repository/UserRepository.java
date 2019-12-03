package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
