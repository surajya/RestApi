package com.book.booktest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.booktest.Service.BookService;
import com.book.booktest.entity.Book;

@RestController
@RequestMapping("/book")
public class BookController {
    BookService bs;
    public BookController(BookService bookService){
        this.bs=bookService;
    }

    //Read all books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> list= bs.getAllBooks();        
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }
    
    //read book by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getonbook(@PathVariable("id") int id){
        Optional<Book> book=bs.getBookById(id);
        if(book==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.of(Optional.of(book));
    }


    //add book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book book1=null;
        try {
            book1=this.bs.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(book1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } 
    }


    //delete book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        
        try {
            this.bs.deleteBook(id);
            return ResponseEntity.status(HttpStatus.GONE).build();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }


    //update book by id
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id){
        try {
            this.bs.updateBook(book,id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}