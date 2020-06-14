package ru.job4j.userservlet.cache;


import ru.job4j.userservlet.model.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class UserStorage {
    private static final UserStorage INSTANCE = new UserStorage();
    private ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

    private UserStorage() {
    }

    public Collection<User> values() {
        return this.users.values();
    }

    public static UserStorage getInstance() {
        return INSTANCE;
    }

    public void add (User user) {
        users.put(user.getId(), user);
    }

    public void delete (int id) {
        users.remove(id);
    }

    public User get (int id) {
        return users.get(id);
    }

    public void update (User user) {
        users.replace(user.getId(), user);
    }
}
