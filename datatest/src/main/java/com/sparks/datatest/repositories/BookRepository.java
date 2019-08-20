package com.sparks.datatest.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sparks.datatest.models.book;



@Repository
public interface BookRepository extends CrudRepository<book, Long>{
    // this method retrieves all the books from the database
    List<book> findAll();
    // this method find a book by their description
    List<book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}