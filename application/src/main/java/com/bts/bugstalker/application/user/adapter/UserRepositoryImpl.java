package com.bts.bugstalker.application.user.adapter;

import com.bts.bugstalker.application.user.persistence.UserDAO;
import com.bts.bugstalker.application.user.persistence.UserDAOMapper;
import com.bts.bugstalker.application.user.persistence.UserRepositoryJpa;
import com.bts.bugstalker.domain.entity.User;
import com.bts.bugstalker.usecase.common.exception.MethodNotImplementedException;
import com.bts.bugstalker.usecase.user.exception.UserNotFoundException;
import com.bts.bugstalker.usecase.user.port.UserRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJpa userRepositoryJpa;

    @Override
    public User create(User user) {
        UserDAO userDAO = UserDAOMapper.toUserDao(user);
        return UserDAOMapper.toDomainUser(userRepositoryJpa.save(userDAO));
    }

    @Override
    public Optional<User> findById(String id) {
        UserDAO userDAO = userRepositoryJpa.findById(Long.valueOf(id))
                .orElseThrow(() -> new UserNotFoundException("not found by id"));
        return Optional.ofNullable(UserDAOMapper.toDomainUser(userDAO));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return (userRepositoryJpa.findByEmail(email).isPresent())
            ? Optional.ofNullable(UserDAOMapper.toDomainUser(userRepositoryJpa.findByEmail(email).get()))
            : Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        return userRepositoryJpa.findAll().stream()
                .map(UserDAOMapper::toDomainUser)
                .collect(Collectors.toList());
    }
}
