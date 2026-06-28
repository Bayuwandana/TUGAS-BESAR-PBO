package com.tup.temp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tup.temp.entity.Book;
import com.tup.temp.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Book updateBook(
            @PathVariable Long id,
            @RequestBody Book updatedBook) {

        Book book = bookService.getById(id);

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setStock(updatedBook.getStock());
        book.setCategory(updatedBook.getCategory());

        return bookService.save(book);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}