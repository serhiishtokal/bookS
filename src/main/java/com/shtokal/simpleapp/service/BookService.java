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

    public Book saveProduct(Book book) {
        return repository.save(book);
    }

    public List<Book> saveProducts(List<Book> books) {
        return repository.saveAll(books);
    }

    public List<Book> getProducts() {
        return repository.findAll();
    }

    public Book getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Book getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Book updateProduct(Book book) {
        Book existingBook = repository.findById(book.getId()).orElse(null);
        existingBook.setName(book.getName());
        existingBook.setPages(book.getPages());
        existingBook.setPrice(book.getPrice());
        return repository.save(existingBook);
    }


}
