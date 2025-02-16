package dev.noah.BookManager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class MyUser implements UserDetails {
    @Id
    private String username;
    private String password;
    private String email;

    private ArrayList<String> chosenBooks = new ArrayList<>();
    private ArrayList<String> startedBooks = new ArrayList<>();
    private ArrayList<String> finishedBooks = new ArrayList<>();

//    public MyUser(String username, String password, String email) {
//        this.username = username;
//        this.password = password;
//        this.email = email;
//    }

    public MyUser(){}

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }


    public ArrayList<String> getStartedBooks() {
        return startedBooks;
    }

    public void setStartedBooks(ArrayList<String> startedBooks) {
        this.startedBooks = startedBooks;
    }

    public ArrayList<String> getChosenBooks() {
        return chosenBooks;
    }

    public void setChosenBooks(ArrayList<String> chosenBooks) {
        this.chosenBooks = chosenBooks;
    }

    public ArrayList<String> getFinishedBooks() {
        return finishedBooks;
    }

    public void setFinishedBooks(ArrayList<String> finishedBooks) {
        this.finishedBooks = finishedBooks;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", chosenBooks=" + chosenBooks +
                ", startedBooks=" + startedBooks +
                ", finishedBooks=" + finishedBooks +
                '}';
    }
}
