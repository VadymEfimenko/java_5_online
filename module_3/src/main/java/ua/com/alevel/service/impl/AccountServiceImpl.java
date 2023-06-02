package ua.com.alevel.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Account;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.entity.User;
import ua.com.alevel.repository.AccountRepository;
import ua.com.alevel.repository.OperationRepository;
import ua.com.alevel.service.AccountService;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final OperationRepository operationRepository;

    public AccountServiceImpl(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @Override
    public void create(Account account) {
        Long numberOfNewAcc = generateNumberOfAcc();
        account.setNumber(numberOfNewAcc);
        accountRepository.save(account);
    }

    @Override
    public List<Account> findAllByUserId(Long userId) {
        return accountRepository.findAllByUserId(userId);
    }

    @Override
    public Account findByNumber(Long number) {
        return accountRepository.findByNumber(number);
    }

    @Override
    public Boolean checkIfAccountExistByNumber(Long number) {
        return accountRepository.existsAccountByNumber(number);
    }

    @Override
    public void deleteAllByUserId(Long userId) {
        accountRepository.deleteAllByUserId(userId);
    }

    @Override
    public Account findById(Long accountId) {
        return accountRepository.findById(accountId).get();
    }

    @Override
    public void send(Operation operation, Long accountToNumber) {
        Account accountTo = findByNumber(accountToNumber);
        Account accountFrom = operation.getAccountFrom();
        operation.setAccountTo(accountTo);

        accountFrom.setBalance(accountFrom.getBalance() - operation.getSum());
        accountTo.setBalance(accountTo.getBalance() + operation.getSum());

        operationRepository.save(operation);
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);

    }

    @Override
    public User findUserByAccountId(Long accountId) {
        Account account = findById(accountId);
        return account.getUser();
    }

    private Long generateNumberOfAcc() {
        Long number = (long) new Random().nextInt(9000) + 1000;
        if (checkIfAccountExistByNumber(number)) {
            return generateNumberOfAcc();
        }
        return number;
    }
}
