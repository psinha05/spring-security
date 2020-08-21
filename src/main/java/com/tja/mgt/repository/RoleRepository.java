package com.tja.mgt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tja.mgt.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(Role name);
}
