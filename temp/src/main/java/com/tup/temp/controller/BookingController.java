package com.tup.temp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.dto.BookingRequest;
import com.tup.temp.entity.Book;
import com.tup.temp.entity.Booking;
import com.tup.temp.entity.Fine;
import com.tup.temp.entity.User;
import com.tup.temp.repository.BookRepository;
import com.tup.temp.repository.UserRepository;
import com.tup.temp.service.BookingService;
import com.tup.temp.repository.FineRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@RestController
@RequestMapping("/booking")
public class BookingController {


private final BookingService bookingService;
private final UserRepository userRepository;
private final BookRepository bookRepository;
private final FineRepository fineRepository;

public BookingController( BookingService bookingService, UserRepository userRepository,BookRepository bookRepository,FineRepository fineRepository) {

    this.bookingService = bookingService;
    this.userRepository = userRepository;
    this.bookRepository = bookRepository;
    this.fineRepository = fineRepository;
    }

    @PostMapping("/add")
    public Booking addBooking(@RequestBody BookingRequest request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        if (book.getStock() <= 0) {
            throw new RuntimeException("Book is out of stock");
        }
        book.setStock(book.getStock() - 1);
        bookRepository.save(book);

        Booking booking = new Booking();

        booking.setUser(user);
        booking.setBook(book);
        booking.setBorrowDate(request.getBorrowDate());
        booking.setDueDate(request.getDueDate());
        booking.setExpired(false);
        booking.setStatus("BORROWED");

        return bookingService.save(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }
    
    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(
            @PathVariable Long userId) {

        return bookingService.getByUserId(userId);
    }
    
    @PostMapping("/return/{id}")
    public Booking returnBook(@PathVariable Long id) {

        Booking booking = bookingService.getById(id);

        Book book = booking.getBook();

        book.setStock(book.getStock() + 1);
        bookRepository.save(book);

        booking.setStatus("RETURNED");

        if (LocalDate.now().isAfter(booking.getDueDate())) {

            booking.setExpired(true);

            Fine fine = new Fine();

            fine.setBooking(booking);

            long daysLate = ChronoUnit.DAYS.between(
                    booking.getDueDate(),
                    LocalDate.now()
            );

            fine.setAmount(daysLate * 1000);

            fine.setPaid(false);

            fineRepository.save(fine);

        } else {

            booking.setExpired(false);

        }

        return bookingService.save(booking);
    }

    
}
