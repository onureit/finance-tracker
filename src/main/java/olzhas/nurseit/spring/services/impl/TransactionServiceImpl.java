package olzhas.nurseit.spring.services.impl;

import olzhas.nurseit.spring.entities.Account;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.repositories.AccountRepository;
import olzhas.nurseit.spring.repositories.TransactionRepository;
import olzhas.nurseit.spring.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createTransaction(String username, Transaction transaction) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Username not found"));

        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getMyTransactions(String username){
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Username not found"));
        return transactionRepository.findByAccountId(account.getId());
    }
}