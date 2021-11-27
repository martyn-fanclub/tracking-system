package com.github.martynfunclub.trackingsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.martynfunclub.trackingsystem.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByName(String name);
}
