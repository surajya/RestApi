package com.book.booktest.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Writer writer;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWriter(Writer writer) {
        this.writer = writer;
    }
    
    

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Writer getWriter() {
        return writer;
    }
    
    public Book(int id, String name, Writer writer) {
        this.id = id;
        this.name = name;
        this.writer = writer;
    }
    public Book() {
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", writer=" + writer + "]";
    }
}
