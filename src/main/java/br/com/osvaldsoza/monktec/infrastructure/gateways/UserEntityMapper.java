package br.com.osvaldsoza.monktec.infrastructure.gateways;

import br.com.osvaldsoza.monktec.domain.entity.User;
import br.com.osvaldsoza.monktec.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    UserEntity toEntity(User userDomainObj){
        return new UserEntity(userDomainObj.username(), userDomainObj.password(), userDomainObj.email());
    }

    User toDomainObj(UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }
}
