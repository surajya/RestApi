package com.book.booktest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int writerId;
    private String writerName;
    private String writerLanguage;
    
    @OneToOne(mappedBy = "writer")
    @JsonBackReference
    private Book book;

    public int getWriterId() {
        return writerId;
    }
    public String getWriterName() {
        return writerName;
    }
    public String getWriterLanguage() {
        return writerLanguage;
    }
    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }
    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
    public void setWriterLanguage(String writerLanguage) {
        this.writerLanguage = writerLanguage;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    
    public Writer(int writerId, String writerName, String writerLanguage) {
        this.writerId = writerId;
        this.writerName = writerName;
        this.writerLanguage = writerLanguage;
    }
    public Writer() {
    }
    @Override
    public String toString() {
        return "Writer [writerId=" + writerId + ", writerName=" + writerName + ", writerLanguage=" + writerLanguage
                + "]";
    }
    

    
}
