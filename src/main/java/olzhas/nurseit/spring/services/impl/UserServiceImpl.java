package olzhas.nurseit.spring.services.impl;

import olzhas.nurseit.spring.dtos.UserResponseDTO;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.entities.User;
import olzhas.nurseit.spring.repositories.TransactionRepository;
import olzhas.nurseit.spring.repositories.UserRepository;
import olzhas.nurseit.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public UserResponseDTO getUserById(int id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
        List<Transaction> transactions = transactionRepository.findByUserId(id);
        return new UserResponseDTO(user, transactions);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }
}