package olzhas.nurseit.spring.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthRequestDTO {
    private String username;
    private String password;
}