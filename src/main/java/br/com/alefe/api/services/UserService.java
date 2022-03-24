package br.com.alefe.api.services;

import br.com.alefe.api.domain.User;
import br.com.alefe.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO user);

    User update(UserDTO user);

    void delete(Integer id);
}
