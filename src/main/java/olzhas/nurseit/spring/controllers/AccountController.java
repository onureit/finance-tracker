package olzhas.nurseit.spring.controllers;

import olzhas.nurseit.spring.dtos.AccountResponseDTO;
import olzhas.nurseit.spring.entities.Account;
import olzhas.nurseit.spring.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/me")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/me")
    public ResponseEntity<AccountResponseDTO> showAccount() {
        String name = getName();
        AccountResponseDTO response =  accountService.getAccountResponseDTO(name);
        return new  ResponseEntity<>(response, HttpStatus.OK);
    }

    private String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
