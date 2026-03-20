package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.dtos.AuthRequestDTO;
import olzhas.nurseit.spring.dtos.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO register(AuthRequestDTO request);
    AuthResponseDTO login(AuthRequestDTO request);
}
