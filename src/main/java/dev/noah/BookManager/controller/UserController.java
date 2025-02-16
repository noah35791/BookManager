package dev.noah.BookManager.controller;

import dev.noah.BookManager.model.MyUser;
import dev.noah.BookManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public MyUser register(@RequestBody MyUser user) {
        return service.createUser(user);
    }

    @GetMapping
    public List<MyUser> getUsers() {
        return service.getUsers();
    }

    @PatchMapping("/{username}/books/{isbn}/choose")
    public MyUser chooseBook(@PathVariable String username, @PathVariable String isbn) {
        return service.chooseBook(username, isbn);
    }

    @PatchMapping("/{username}/books/{isbn}/start")
    public MyUser startedBook(@PathVariable String username, @PathVariable String isbn) {
        return service.startBook(username, isbn);
    }

    @PatchMapping("/{username}/books/{isbn}/finish")
    public MyUser finishedBook(@PathVariable String username, @PathVariable String isbn) {
        return service.finishBook(username, isbn);
    }

    @DeleteMapping("/{username}")
    public Integer deleteUser(@PathVariable String username) {
        return service.deleteUser(username);
    }
}
