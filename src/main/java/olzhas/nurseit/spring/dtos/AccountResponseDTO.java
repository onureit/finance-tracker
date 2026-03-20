package olzhas.nurseit.spring.dtos;

import lombok.Getter;
import olzhas.nurseit.spring.entities.Account;
import olzhas.nurseit.spring.entities.Transaction;

import java.util.List;

// DTO (Data Transfer Object) instead of just reusing your Model (Entity).
@Getter
public class AccountResponseDTO {
    private int id;
    private String name;

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.name = account.getUsername();
    }
}
