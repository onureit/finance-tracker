package olzhas.nurseit.spring.services.impl;

import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.entities.User;
import olzhas.nurseit.spring.repositories.TransactionRepository;
import olzhas.nurseit.spring.repositories.UserRepository;
import olzhas.nurseit.spring.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTransaction(int userId, Transaction transaction) {
        // FIXED: userId is who OWNS the transaction, not the transaction's own id
        User user = userRepository.getReferenceById(userId);
        transaction.setUser(user);
        transactionRepository.save(transaction);
    }
}