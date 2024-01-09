package com.book.booktest.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.booktest.dao.BookRepository;
import com.book.booktest.entity.Book;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    
    public List<Book> getAllBooks(){
        List<Book> list=bookRepository.findAll();
        return list;
    }

    
    public Optional<Book> getBookById(int id){
        Optional<Book> book=null;
        try {
        book=this.bookRepository.findById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        return book;
    }

    public Book addBook(Book book){
        this.bookRepository.save(book);
        return book;
    }

    public void deleteBook(int id){
        this.bookRepository.deleteById(id);
    }

    public void updateBook(Book book, int bid){
        book.setId(bid);
        this.bookRepository.save(book);
    }
}
