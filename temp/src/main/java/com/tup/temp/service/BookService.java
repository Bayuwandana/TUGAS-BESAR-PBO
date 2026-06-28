package com.tup.temp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tup.temp.entity.Book;
import com.tup.temp.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long id) {
    return bookRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}