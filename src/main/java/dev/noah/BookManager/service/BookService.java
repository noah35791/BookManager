package dev.noah.BookManager.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.noah.BookManager.api.GoogleBooksAPI;
import dev.noah.BookManager.model.Book;
import dev.noah.BookManager.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    public List<Book> getBooks(String query, String title, String author, String subject) throws IOException {
        List<Book> finalBooks = new ArrayList<>();
        String bookRes = GoogleBooksAPI.getBooks(query, title, author, subject);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode booksNode = objectMapper.readTree(bookRes).get("items");
        for(JsonNode bookNode: booksNode) {
            JsonNode volumeInfo = bookNode.get("volumeInfo");

            String isbn;
            String apiAuthor = volumeInfo.has("authors") ? volumeInfo.get("authors").get(0).asText() : "";
            String description = volumeInfo.has("description") ? volumeInfo.get("description").asText() : "";
            String apiTitle = volumeInfo.has("title") ? volumeInfo.get("title").asText() : "";
            String publisher = volumeInfo.has("publisher") ? volumeInfo.get("publisher").asText() : "";
            String imageLink = volumeInfo.has("imageLink") ? volumeInfo.get("imageLink").asText() : "";

            Book book;
            for(JsonNode identifier: volumeInfo.get("industryIdentifiers")) {
                if(identifier.get("type").asText().equals("ISBN_13")) {
                    isbn = identifier.get("identifier").asText();
                    book = new Book(isbn, apiTitle, apiAuthor, description, publisher, imageLink);
                    if(book != null) {
                        repo.save(book);
                        for(Book b: repo.findAll()) {
                            System.out.println(b);
                        }
                        System.out.println("Hi");
                        finalBooks.add(book);
                    }
                }
            }
        }
        return finalBooks;
    }

    public Book createBook(Book book) {
        return repo.save(book);
    }
}
