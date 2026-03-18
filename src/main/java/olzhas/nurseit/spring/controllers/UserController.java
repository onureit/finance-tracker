package olzhas.nurseit.spring.controllers;

import olzhas.nurseit.spring.dtos.UserResponseDTO;
import olzhas.nurseit.spring.entities.User;
import olzhas.nurseit.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserResponseDTO showUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
