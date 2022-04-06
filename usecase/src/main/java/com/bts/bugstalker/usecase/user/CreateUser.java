package com.bts.bugstalker.usecase.user;

import com.bts.bugstalker.domain.entity.User;
import com.bts.bugstalker.usecase.user.exception.UserAlreadyExistsException;
import com.bts.bugstalker.usecase.user.port.UserRepository;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw  new UserAlreadyExistsException(user.getEmail());
        }

        User userToSave = User.builder()
                .id(new Random().nextLong())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .salt(user.getSalt())
                .build();

        return userRepository.create(userToSave);
    }
}
