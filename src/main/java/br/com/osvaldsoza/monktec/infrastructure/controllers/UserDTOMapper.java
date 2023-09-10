package br.com.osvaldsoza.monktec.infrastructure.controllers;

import br.com.osvaldsoza.monktec.domain.entity.User;

public class UserDTOMapper {

   public UserResponse toResponse(User user) {
        return new UserResponse(user.username(), user.email());
    }

    public User toUser(CreateUserRequest request){
        return new User(request.username(), request.email(), request.password());
    }
}
