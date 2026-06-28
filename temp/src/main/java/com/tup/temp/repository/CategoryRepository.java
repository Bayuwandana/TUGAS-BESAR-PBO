package com.tup.temp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tup.temp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}