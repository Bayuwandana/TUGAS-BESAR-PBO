package com.tup.temp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tup.temp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}