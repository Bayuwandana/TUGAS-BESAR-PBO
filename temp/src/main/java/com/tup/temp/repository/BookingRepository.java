package com.tup.temp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tup.temp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
}