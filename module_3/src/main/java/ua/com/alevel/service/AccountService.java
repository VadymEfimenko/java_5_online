package ua.com.alevel.service;

import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.User;

import java.util.List;

public interface AccountService {

    void create(Account account);
    List<Account> findAllByUserId(Long userId);

    Account findByNumber(Long number);

    Boolean checkIfAccountExistByNumber(Long number);

    void deleteAllByUserId(Long userId);

    Account findById(Long accountId);

    void send(Operation operation, Long accountToNumber);

    User findUserByAccountId(Long accountId);
}
