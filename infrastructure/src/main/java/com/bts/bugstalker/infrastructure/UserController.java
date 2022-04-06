package com.bts.bugstalker.infrastructure;

import com.bts.bugstalker.domain.entity.User;
import com.bts.bugstalker.usecase.user.CreateUser;
import com.bts.bugstalker.usecase.user.FindUser;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserController {

    private final FindUser findUser;

    private final CreateUser createUser;

    public UserDTO findUser(String id) {
        User user = findUser.findById(id).orElseThrow();
        return UserDTOMapper.mapDomainUserToDto(user);
    }

    public UserDTO createUser(User user) {
        User createdUser = createUser.createUser(user);
        return UserDTOMapper.mapDomainUserToDto(user);
    }

    public List<UserDTO> findAllUsers() {
        return findUser.findAllUsers().stream()
                .map(UserDTOMapper::mapDomainUserToDto)
                .collect(Collectors.toList());
    }
}
