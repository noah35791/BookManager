package dev.noah.BookManager.service;

import dev.noah.BookManager.model.Book;
import dev.noah.BookManager.model.MyUser;
import dev.noah.BookManager.repo.BookRepository;
import dev.noah.BookManager.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BookRepository bookRepo;

    public MyUser createUser(MyUser user) {
        return userRepo.save(user);
    }

    public List<MyUser> getUsers() {
        return userRepo.findAll();
    }

    public MyUser chooseBook(String username, String isbn) {
        MyUser user = userRepo.findUserByUsername(username);
        Book book = bookRepo.findBookByIsbn(isbn);

        ArrayList<String> books = user.getChosenBooks();
        books.add(book.getIsbn());

        userRepo.save(user);

        return user;
    }

    public MyUser startBook(String username, String isbn) {
        MyUser user = userRepo.findUserByUsername(username);
        Book book = bookRepo.findBookByIsbn(isbn);

        ArrayList<String> books = user.getStartedBooks();
        books.add(book.getIsbn());

        userRepo.save(user);

        return user;
    }

    public MyUser finishBook(String username, String isbn) {
        MyUser user = userRepo.findUserByUsername(username);
        Book book = bookRepo.findBookByIsbn(isbn);

        ArrayList<String> books = user.getFinishedBooks();
        books.add(book.getIsbn());

        userRepo.save(user);

        return user;
    }

    @Transactional
    public Integer deleteUser(String username) {
        return userRepo.deleteUserByUsername(username);
    }
}
