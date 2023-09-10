package br.com.osvaldsoza.monktec.infrastructure.gateways;

import br.com.osvaldsoza.monktec.application.gateways.UserGateway;
import br.com.osvaldsoza.monktec.domain.entity.User;
import br.com.osvaldsoza.monktec.infrastructure.persistence.UserEntity;
import br.com.osvaldsoza.monktec.infrastructure.persistence.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserRepositoryGateway implements UserGateway {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity userSaved = userRepository.save(userEntity);
        return userEntityMapper.toDomainObj(userSaved);
    }

    @Override
    public List<User> listUsers() {
        Iterable<UserEntity> usersEntityIterable = userRepository.findAll();

        List<User> users = StreamSupport
                .stream(usersEntityIterable.spliterator(), false)
                .collect(Collectors.toList())
                .stream()
                .map(entity -> new User(entity.getUsername(), entity.getPassword(), entity.getEmail()))
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        userRepository.delete(userEntity);
    }
}
