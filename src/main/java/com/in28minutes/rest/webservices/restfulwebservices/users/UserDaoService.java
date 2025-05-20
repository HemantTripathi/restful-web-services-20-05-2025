package com.in28minutes.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int usersCount=0;

    static {
        users.add(new User(usersCount++,"Hemant", LocalDate.now().minusYears(30)));
        users.add(new User(usersCount++,"Deepika", LocalDate.now().minusYears(28)));
        users.add(new User(usersCount++,"Dhriti", LocalDate.now().minusYears(2)));
        users.add(new User(usersCount++,"Kushal", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findSpecificUser(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public void deleteSpecificUser(int id){
        users.removeIf(user -> user.getId().equals(id));
    }

}
