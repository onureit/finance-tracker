package olzhas.nurseit.spring.controllers;

import jakarta.validation.Valid;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@PathVariable int userId,
                                                  @Valid @RequestBody Transaction transaction) {
        transactionService.createTransaction(userId, transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}