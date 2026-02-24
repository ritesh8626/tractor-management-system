package com.tractor.tractormanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tractor.tractormanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}