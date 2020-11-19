package com.shtokal.simpleapp.repository;

import com.shtokal.simpleapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByName(String name);
}

