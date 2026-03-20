package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.dtos.AccountResponseDTO;
import olzhas.nurseit.spring.entities.Account;

import java.util.List;

public interface AccountService {
    AccountResponseDTO getAccountResponseDTO(String username);
}
