package br.com.osvaldsoza.monktec.utils;

import br.com.osvaldsoza.monktec.application.gateways.UserGateway;
import br.com.osvaldsoza.monktec.application.usecases.UserInteractor;
import br.com.osvaldsoza.monktec.infrastructure.controllers.UserDTOMapper;
import br.com.osvaldsoza.monktec.infrastructure.gateways.UserEntityMapper;
import br.com.osvaldsoza.monktec.infrastructure.gateways.UserRepositoryGateway;
import br.com.osvaldsoza.monktec.infrastructure.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserInteractor createUserCase(UserGateway userGateway) {
        return new UserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
