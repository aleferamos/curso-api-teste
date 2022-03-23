package br.com.alefe.api.services;

import br.com.alefe.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
