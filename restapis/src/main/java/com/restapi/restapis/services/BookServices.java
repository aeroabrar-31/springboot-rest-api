package com.restapi.restapis.services;

import com.restapi.restapis.Dao.booksRepository;
import com.restapi.restapis.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BookServices {
//    private static List<Books> list=new ArrayList<>();
//    static {
//
//        list.add(new Books(12,"java programing","abrar"));
//        list.add(new Books(15,"python programing","kalam"));
//        list.add(new Books(22,"C++ programing","chand"));
//    }

    @Autowired
    booksRepository brep;


    public List<Book> getAllbooks()
    {
        List<Book> list = (List<Book>) brep.findAll();
        return list;
    }

    public Book getBookById(int id) {
        Optional<Book> books = brep.findById(id);
        return books.get();
    }

    public void addbooks(Book b)
    {
        brep.save(b);
        System.out.println("addbooks()");
    }

    public Book delete(int id) {
        Optional<Book> b=brep.findById(id);
        brep.deleteById(id);

        return b.get();
    }

    public Book update(int id, Book temp) {
        Book b=this.getBookById(id);

        brep.save(temp);
        return b;
    }
}
