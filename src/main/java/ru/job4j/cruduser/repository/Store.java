package ru.job4j.cruduser.repository;

import ru.job4j.cruduser.model.User;

import java.util.List;

/**
 * Created by Comp on 19.10.2018.
 */

public interface Store {
    void add(User user);

    void update(int id, User user);

    void delete(int id);

    User findById(int id);

    User findLogin(String login);

    List<User> findByAll();
}
