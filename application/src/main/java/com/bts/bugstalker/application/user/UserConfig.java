package com.bts.bugstalker.application.user;

import com.bts.bugstalker.application.user.adapter.UserRepositoryImpl;
import com.bts.bugstalker.application.user.persistence.UserRepositoryJpa;
import com.bts.bugstalker.infrastructure.UserController;
import com.bts.bugstalker.usecase.user.CreateUser;
import com.bts.bugstalker.usecase.user.FindUser;
import com.bts.bugstalker.usecase.user.port.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserConfig {

    private final UserRepositoryJpa userRepositoryJpa;

    @Bean
    public UserController getUserController() {
        return new UserController(getFindUser(), getCreateUser());
    }

    @Bean
    public FindUser getFindUser() {
        return new FindUser(getUserRepository());
    }

    @Bean
    public UserRepository getUserRepository() {
        return new UserRepositoryImpl(userRepositoryJpa);
    }

    @Bean
    public CreateUser getCreateUser() {
        return new CreateUser(getUserRepository());
    }
}
