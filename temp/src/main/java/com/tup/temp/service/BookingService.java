package com.tup.temp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tup.temp.entity.Booking;
import com.tup.temp.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public Booking getById(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }
    public List<Booking> getByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }
}