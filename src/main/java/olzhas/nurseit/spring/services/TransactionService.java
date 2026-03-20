package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.entities.Transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(String username, Transaction transaction);
    List<Transaction> getMyTransactions(String username);
}