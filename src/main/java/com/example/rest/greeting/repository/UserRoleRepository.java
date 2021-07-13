package com.example.rest.greeting.repository;

import java.util.Optional;

import com.example.rest.greeting.entity.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByUSERID(Long UserId);
}
