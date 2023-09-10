package br.com.osvaldsoza.monktec.infrastructure.controllers;

import br.com.osvaldsoza.monktec.application.usecases.UserInteractor;
import br.com.osvaldsoza.monktec.domain.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserInteractor userInteractor;
    private final UserDTOMapper userDTOMapper;


    public UserController(UserInteractor userInteractor, UserDTOMapper userDTOMapper) {
        this.userInteractor = userInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    UserResponse create(@RequestBody CreateUserRequest request) {
        User user = userDTOMapper.toUser(request);
        User userResponse = userInteractor.createUser(user);
        return userDTOMapper.toResponse(userResponse);
    }

    @GetMapping
    List<UserResponse> list() {

        List<User> users = userInteractor.listUsers();

        List<UserResponse> response = users.stream()
                .map(user -> userDTOMapper.toResponse(user))
                .collect(Collectors.toList());

        return response;
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable(name = "id") Long id){
        userInteractor.deleteUser(id);
    }


}
