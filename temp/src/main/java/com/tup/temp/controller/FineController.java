package com.tup.temp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.entity.Fine;
import com.tup.temp.service.FineService;

@RestController
@RequestMapping("/fine")
public class FineController {

    private final FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @PostMapping("/add")
    public Fine addFine(@RequestBody Fine fine) {
        return fineService.save(fine);
    }

    @GetMapping("/all")
    public List<Fine> getAllFines() {
        return fineService.getAll();
    }
    @GetMapping("/user/{userId}")
    public List<Fine> getUserFines(
            @PathVariable Long userId) {

        return fineService.getByUserId(userId);
    }
    @PutMapping("/update/{id}")
    public Fine updateFine(
            @PathVariable Long id,
            @RequestBody Fine updatedFine) {

        Fine fine = fineService.getById(id);

        fine.setAmount(updatedFine.getAmount());

        return fineService.save(fine);
    }

    @PutMapping("/pay/{id}")
    public Fine payFine(@PathVariable Long id) {

        Fine fine = fineService.getById(id);

        fine.setPaid(true);

        return fineService.save(fine);
    }

    @PutMapping("/lost/{id}")
    public Fine lostBook(@PathVariable Long id) {

        Fine fine = fineService.getById(id);

        fine.setAmount(fine.getAmount() + 50000);

        return fineService.save(fine);
    }

}