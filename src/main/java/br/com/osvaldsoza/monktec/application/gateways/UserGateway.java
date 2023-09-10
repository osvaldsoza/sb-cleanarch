package br.com.osvaldsoza.monktec.application.gateways;

import br.com.osvaldsoza.monktec.domain.entity.User;

import java.util.List;

public interface UserGateway {

    User createUser(User user);

    List<User> listUsers();

    void deleteUser(Long id);
}
