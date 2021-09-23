package com.me.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 4;

    static {
        users.add(new User(1, "Jhon", new Date()));
        users.add(new User(2, "Miguel", new Date()));
        users.add(new User(3, "Pedro", new Date()));
        users.add(new User(4, "Pablo", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);

        return user;
    }

    public User findOne(int id) {
        for (User user:users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
