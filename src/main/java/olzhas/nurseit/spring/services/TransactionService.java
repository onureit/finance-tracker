package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.entities.Transaction;

public interface TransactionService {
    void createTransaction(int userId, Transaction transaction);
}