package com.shtokal.simpleapp.controller;

import com.shtokal.simpleapp.entity.Book;
import com.shtokal.simpleapp.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private final BookService service;

    public BookController(BookService service) {
        this.service = service;

    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PostMapping("/addBookss")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return service.saveBooks(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBookss() {
        return service.getBooks();
    }

    @GetMapping("/bookById/{id}")
    public Book findBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @GetMapping("/book/{name}")
    public Book findBookByName(@PathVariable String name) {
        return service.getBookByName(name);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
}
