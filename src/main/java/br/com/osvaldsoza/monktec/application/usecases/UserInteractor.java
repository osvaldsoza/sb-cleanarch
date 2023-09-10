package br.com.osvaldsoza.monktec.application.usecases;

import br.com.osvaldsoza.monktec.application.gateways.UserGateway;
import br.com.osvaldsoza.monktec.domain.entity.User;

import java.util.List;

public class UserInteractor {

    private final UserGateway userGateway;

    public UserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }

    public List<User> listUsers() {
        return userGateway.listUsers();
    }

    public void deleteUser(Long id){
        userGateway.deleteUser(id);
    }
}
