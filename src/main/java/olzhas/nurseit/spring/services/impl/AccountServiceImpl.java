package olzhas.nurseit.spring.services.impl;

import olzhas.nurseit.spring.dtos.AccountResponseDTO;
import olzhas.nurseit.spring.entities.Account;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.repositories.AccountRepository;
import olzhas.nurseit.spring.repositories.TransactionRepository;
import olzhas.nurseit.spring.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponseDTO getAccountResponseDTO(String username) {
        Account account =  accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found: " + username));
        return new AccountResponseDTO(account);
    }


}