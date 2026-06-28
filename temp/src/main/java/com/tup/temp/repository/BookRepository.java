package com.tup.temp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tup.temp.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}