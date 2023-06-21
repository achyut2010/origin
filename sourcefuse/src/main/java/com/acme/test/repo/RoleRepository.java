package com.acme.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.test.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
