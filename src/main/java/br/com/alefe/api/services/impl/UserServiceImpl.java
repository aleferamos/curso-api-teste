package br.com.alefe.api.services.impl;

import br.com.alefe.api.domain.User;
import br.com.alefe.api.domain.dto.UserDTO;
import br.com.alefe.api.repositories.UserRepository;
import br.com.alefe.api.services.UserService;
import br.com.alefe.api.services.exceptions.DataIntegratyViolationException;
import br.com.alefe.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return  obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO user) {
        User userSave = new User(user);
        findByEmail(user);
        return userRepository.save(userSave);
    }

    @Override
    public User update(UserDTO user) {
        findByEmail(user);
        User userSave = new User(user);

        return userRepository.save(userSave);
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(findById(id));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("Objeto não encontrado");
        }
    }

}
