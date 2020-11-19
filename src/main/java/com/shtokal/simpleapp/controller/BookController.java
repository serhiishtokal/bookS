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
        return service.saveProduct(book);
    }

    @PostMapping("/addBookss")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return service.saveProducts(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBookss() {
        return service.getProducts();
    }

    @GetMapping("/bookById/{id}")
    public Book findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/book/{name}")
    public Book findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Book updateProduct(@RequestBody Book book) {
        return service.updateProduct(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
}
