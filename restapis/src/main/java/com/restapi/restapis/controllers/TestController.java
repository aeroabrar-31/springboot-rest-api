package com.restapi.restapis.controllers;

import com.restapi.restapis.entities.Book;
import com.restapi.restapis.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private BookServices bookservice;

    @GetMapping("/books")
    public List<Book> test()
    {
        System.out.println("Fetched all books");
        return bookservice.getAllbooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id)
    {
        System.out.println("Selected by id");
        return bookservice.getBookById(id);
    }

    @PostMapping("/books")
    public Book addbook(@RequestBody Book b)
    {
        bookservice.addbooks(b);
        System.out.println("Added successfully in addbook");
        return b;
    }
    @DeleteMapping("book/{id}")
    public Book deletebook(@PathVariable("id") int id)
    {
        Book b=bookservice.delete(id);
        System.out.println("Deleted successfully !!"+b);
        return b;
    }
    @PutMapping("book/{id}")
    public Book updatebook(@PathVariable("id") int id, @RequestBody Book book)
    {
        Book b=bookservice.update(id,book);
        System.out.println("Updated books !!"+b);
        return b;
    }

}
