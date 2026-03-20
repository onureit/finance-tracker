package olzhas.nurseit.spring.controllers;

import jakarta.validation.Valid;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/me/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        String userName = getName();
        return new ResponseEntity<>(transactionService.getMyTransactions(userName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody Transaction transaction) {
        String userName = getName();
        transactionService.createTransaction(userName, transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private String getName(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
}