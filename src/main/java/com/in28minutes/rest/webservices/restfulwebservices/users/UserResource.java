package com.in28minutes.rest.webservices.restfulwebservices.users;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveSpecificUser(@PathVariable Integer id){
        User user = userDaoService.findSpecificUser(id);
        if(user == null)
            throw new UserNotFoundException("id:"+id);
        return userDaoService.findSpecificUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteSpecificUser(@PathVariable Integer id){
        User user = userDaoService.findSpecificUser(id);
        if(user == null)
            throw new UserNotFoundException("id:"+id);
        else userDaoService.deleteSpecificUser(id);
    }
}
