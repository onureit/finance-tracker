package olzhas.nurseit.spring.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthResponseDTO {
    private String token;
    private String username;

    public  AuthResponseDTO(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
