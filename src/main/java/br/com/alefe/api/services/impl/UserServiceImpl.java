package br.com.alefe.api.services.impl;

import br.com.alefe.api.domain.User;
import br.com.alefe.api.repositories.UserRepository;
import br.com.alefe.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return  obj.orElse(null);
    }

}
