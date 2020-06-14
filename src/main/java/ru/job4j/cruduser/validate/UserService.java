package ru.job4j.cruduser.validate;


import ru.job4j.cruduser.model.User;

import java.sql.Timestamp;
import java.util.List;

public interface UserService {
    List<User> findAll();

    boolean add(String name, String email, String login, Timestamp createDate);

    boolean update(int id, String name, String email, String login, Timestamp createDate);

    boolean delete(int id);
}
