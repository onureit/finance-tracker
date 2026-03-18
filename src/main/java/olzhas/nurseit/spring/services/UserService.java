package olzhas.nurseit.spring.services;

import olzhas.nurseit.spring.dtos.UserResponseDTO;
import olzhas.nurseit.spring.entities.User;

import java.util.List;

public interface UserService {
    UserResponseDTO getUserById(int userId);
    List<User> getAllUsers();
    void createUser(User user);
}
