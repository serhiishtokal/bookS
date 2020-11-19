package com.shtokal.simpleapp.service;

import com.shtokal.simpleapp.entity.Book;
import com.shtokal.simpleapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


   private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book) {
        return repository.save(book);
    }

    public List<Book> saveBooks(List<Book> books) {
        return repository.saveAll(books);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Book getBookByName(String name) {
        return repository.findByName(name);
    }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "book removed !! " + id;
    }

    public Book updateBook(Book book) {
        Book existingBook = repository.findById(book.getId()).orElse(null);
        existingBook.setName(book.getName());
        existingBook.setPages(book.getPages());
        existingBook.setPrice(book.getPrice());
        return repository.save(existingBook);
    }


}
