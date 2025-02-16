package dev.noah.BookManager.repo;

import dev.noah.BookManager.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String> {
    public MyUser findUserByUsername(String username);
    public Integer deleteUserByUsername(String username);
}
