package com.bts.bugstalker.application.user;

import com.bts.bugstalker.domain.entity.User;
import com.bts.bugstalker.infrastructure.UserController;
import com.bts.bugstalker.infrastructure.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserHttpEndpoint {

    private final UserController userController;

    @GetMapping("/user/{userId}")
    public UserDTO getUser(@PathVariable final String userId) {
        return userController.findUser(userId);
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        return userController.findAllUsers();
    }

    @PostMapping( "/user")
    public UserDTO createUser(@RequestBody User newUser) {
        return userController.createUser(newUser);
    }

}
