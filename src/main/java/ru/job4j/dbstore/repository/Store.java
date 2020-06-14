package ru.job4j.dbstore.repository;

import java.util.List;

/**
 * Created by Comp on 19.10.2018.
 */

public interface Store<User> {
    void add(User user);

    void update(int id, User user);

    void delete(int id);

    User findById(int id);

    User findLogin(String login);

    List<User> findByAll();
}
