package com.book.booktest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.booktest.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
}
