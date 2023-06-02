package ua.com.alevel.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User> {

    void deleteAllAccountsById(Long userId);
}