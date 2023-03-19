package com.example.booksearch.controller;

import com.example.booksearch.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private BooksController booksController;

    @GetMapping
    public List<Book> searchBooks(@RequestParam("q") String searchTerm) {
        List<Book> filteredBooks = booksController.getBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())
                        || book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())
                        || book.getCategory().toLowerCase().contains(searchTerm.toLowerCase()))
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());

        return filteredBooks;
    }
}
