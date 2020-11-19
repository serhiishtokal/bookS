package com.shtokal.simpleapp.controller;

import com.shtokal.simpleapp.entity.Book;
import com.shtokal.simpleapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {


    private final  ProductService service;

    public BookController(ProductService service) {
        this.service = service;

    }

    @PostMapping("/addProduct")
    public Book addProduct(@RequestBody Book book) {
        return service.saveProduct(book);
    }

    @PostMapping("/addProducts")
    public List<Book> addProducts(@RequestBody List<Book> books) {
        return service.saveProducts(books);
    }

    @GetMapping("/products")
    public List<Book> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Book findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
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
