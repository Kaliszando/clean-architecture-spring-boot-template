package com.bts.bugstalker.application.user.persistence;

import com.bts.bugstalker.domain.entity.User;

public class UserDAOMapper {

    public static UserDAO toUserDao(User user) {
        return UserDAO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getUsername())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .salt(user.getSalt())
                .build();
    }

    public static User toDomainUser(UserDAO userDAO) {
        return User.builder()
                .id(userDAO.getId())
                .username(userDAO.getUsername())
                .firstName(userDAO.getUsername())
                .lastName(userDAO.getLastName())
                .email(userDAO.getEmail())
                .password(userDAO.getPassword())
                .salt(userDAO.getSalt())
                .build();
    }
}
