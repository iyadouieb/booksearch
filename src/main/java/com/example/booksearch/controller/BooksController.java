package com.example.booksearch.controller;

import com.example.booksearch.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private List<Book> books = Arrays.asList(
            new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction"),
            new Book(2L, "To Kill a Mockingbird", "Harper Lee", "Fiction"),
            new Book(3L, "1984", "George Orwell", "Science Fiction")
    );

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }
}
