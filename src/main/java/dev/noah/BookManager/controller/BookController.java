package dev.noah.BookManager.controller;

import dev.noah.BookManager.model.Book;
import dev.noah.BookManager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService service;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam String query, @RequestParam(required = false) String title,
                               @RequestParam(required = false) String author, @RequestParam(required = false) String subject) throws IOException {
        return service.getBooks(query, title, author, subject);
    }
}
