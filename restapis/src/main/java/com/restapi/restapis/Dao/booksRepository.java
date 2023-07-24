package com.restapi.restapis.Dao;

import com.restapi.restapis.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface booksRepository extends CrudRepository<Book,Integer> {


    void deleteById(int id);
}
