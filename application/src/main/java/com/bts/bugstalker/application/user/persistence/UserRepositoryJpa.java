package com.bts.bugstalker.application.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserDAO, Long> {

    Optional<UserDAO> findByEmail(String email);
}
