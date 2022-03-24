package br.com.alefe.api.config;

import br.com.alefe.api.domain.User;
import br.com.alefe.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;


    @Bean
    public void startDB(){
        User u1 = new User(null, "Alefe Patrick", "alefepdias@gmail.com", "alefek159");
        User u2 = new User(null, "Lucas Adriano", "lucasadrianodias@gmail.com", "123");

        userRepository.saveAll(List.of(u1, u2));
    }
}
