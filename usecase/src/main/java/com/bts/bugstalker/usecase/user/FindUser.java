package com.bts.bugstalker.usecase.user;

import com.bts.bugstalker.domain.entity.User;
import com.bts.bugstalker.usecase.user.port.UserRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FindUser {

    private final UserRepository repository;

    public Optional<User> findById(final String id) {
        return repository.findById(id);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

}
