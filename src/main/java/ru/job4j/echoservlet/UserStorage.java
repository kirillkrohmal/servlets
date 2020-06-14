package ru.job4j.echoservlet;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Comp on 23.01.2019.
 */
public class UserStorage {
    private static final UserStorage INSTANCE = new UserStorage();
    private List<User> users = new CopyOnWriteArrayList<>();

    private UserStorage() {
    }

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public User add(User user) {
        this.users.add(user);
        return user;
    }

    public List<User> getUsers() {
        return this.users;
    }


}


