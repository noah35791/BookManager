package dev.noah.BookManager.controller;

import dev.noah.BookManager.model.Book;
import dev.noah.BookManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(service.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam String query, @RequestParam(required = false) String title,
                               @RequestParam(required = false) String author, @RequestParam(required = false) String subject) throws IOException {

        return new ResponseEntity<>(service.getBooks(query, title, author, subject), HttpStatus.OK);
    }
}