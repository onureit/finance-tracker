package olzhas.nurseit.spring.dtos;

import lombok.Getter;
import olzhas.nurseit.spring.entities.Transaction;
import olzhas.nurseit.spring.entities.User;

import java.util.List;

// DTO (Data Transfer Object) instead of just reusing your Model (Entity).
@Getter
public class UserResponseDTO {
    private int id;
    private String name;
    private List<Transaction> transactions;

    public UserResponseDTO(User user, List<Transaction> transactions) {
        this.id = user.getId();
        this.name = user.getName();
        this.transactions = transactions;
    }
}
