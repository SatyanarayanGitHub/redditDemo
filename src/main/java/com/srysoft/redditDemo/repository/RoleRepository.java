package com.srysoft.redditDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srysoft.redditDemo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
