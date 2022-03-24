package br.com.alefe.api.resources;

import br.com.alefe.api.domain.User;
import br.com.alefe.api.domain.dto.UserDTO;
import br.com.alefe.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(modelMapper.map(userService.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(userService.findAll()
                .stream().map(users -> modelMapper.map(users, UserDTO.class)).collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO user){
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(userService.create(user)).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO user, @PathVariable Integer id){
        user.setId(id);
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
