package dev.noah.BookManager.controller;

import dev.noah.BookManager.model.MyUser;
import dev.noah.BookManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<MyUser> register(@RequestBody MyUser user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MyUser>> getUsers() {
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @PatchMapping("/{username}/books/{isbn}/choose")
    public ResponseEntity<MyUser> chooseBook(@PathVariable String username, @PathVariable String isbn) {
        return new ResponseEntity<>(service.chooseBook(username, isbn), HttpStatus.OK);
    }

    @PatchMapping("/{username}/books/{isbn}/start")
    public ResponseEntity<MyUser> startedBook(@PathVariable String username, @PathVariable String isbn) {
        return new ResponseEntity<>(service.startBook(username, isbn), HttpStatus.OK);
    }

    @PatchMapping("/{username}/books/{isbn}/finish")
    public ResponseEntity<MyUser> finishedBook(@PathVariable String username, @PathVariable String isbn) {
        return new ResponseEntity<>(service.finishBook(username, isbn), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Integer> deleteUser(@PathVariable String username) {
        service.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
