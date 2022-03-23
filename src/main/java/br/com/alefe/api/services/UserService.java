package br.com.alefe.api.services;

import br.com.alefe.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
