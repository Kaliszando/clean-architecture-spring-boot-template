package com.bts.bugstalker.infrastructure;

import com.bts.bugstalker.domain.entity.User;

public class UserDTOMapper {

    static UserDTO mapDomainUserToDto(User user) {
        return UserDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
    }
}
