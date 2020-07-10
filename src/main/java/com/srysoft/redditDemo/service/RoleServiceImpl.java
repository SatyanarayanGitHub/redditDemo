package com.srysoft.redditDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srysoft.redditDemo.model.Role;
import com.srysoft.redditDemo.repository.RoleRepository;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role findByName(String name) {
		return this.roleRepository.findByName(name);
	}

}
