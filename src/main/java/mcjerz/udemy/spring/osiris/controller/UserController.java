package mcjerz.udemy.spring.osiris.controller;

import mcjerz.udemy.spring.osiris.domain.User;
import mcjerz.udemy.spring.osiris.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
