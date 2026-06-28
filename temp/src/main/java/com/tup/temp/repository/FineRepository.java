package com.tup.temp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tup.temp.entity.Fine;

public interface FineRepository extends JpaRepository<Fine, Long> {
    List<Fine> findByBookingUserId(Long userId);
}