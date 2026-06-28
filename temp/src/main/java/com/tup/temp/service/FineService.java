package com.tup.temp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tup.temp.entity.Fine;
import com.tup.temp.repository.FineRepository;

@Service
public class FineService {

    private final FineRepository fineRepository;

    public FineService(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    public Fine save(Fine fine) {
        return fineRepository.save(fine);
    }

    public List<Fine> getAll() {
        return fineRepository.findAll();
    }
    public Fine getById(Long id) {
    return fineRepository.findById(id).orElseThrow();
    }
    public List<Fine> getByUserId(Long userId) {
        return fineRepository.findByBookingUserId(userId);
    }
}