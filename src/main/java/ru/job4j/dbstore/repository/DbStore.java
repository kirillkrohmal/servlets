package ru.job4j.dbstore.repository;


import org.apache.commons.dbcp2.BasicDataSource;
import ru.job4j.dbstore.model.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * в том что хранилище создай потоко безопасную коллекцию
 * <p>
 * и имплеменнтируй интерфейс сторе
 * <p>
 * в валидаторе нужно сделать проверки
 * <p>
 * например перед сохранением пользователя проверить что имя и емаил уникальны и не пустые
 * <p>
 * и потом вызвать метод добавления из хранилища и сохранить пользователя
 * <p>
 * или вернуть ответ что логин или емаил занят
 */
public class DbStore implements Store<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore SINGLETON_INSTANCE = new DbStore();
    //private final ValidateService logic = ValidateService.getInstance();
    private final List<User> users = new CopyOnWriteArrayList<>();

    public static DbStore getInstance() {
        return SINGLETON_INSTANCE;
    }

    public DbStore() {
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/java_a_from_z");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("root");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }


    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.prepareStatement("insert into cruduser(name, login, email, createDate) value(?, ?, ?, ?)")
        ) {
            users.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User user) {
        user.setId(id);
        this.users.remove(findById(id));
        this.users.add(user);
    }

    @Override
    public void delete(int id) {
        this.users.remove(findById(id));
    }

    @Override
    public User findById(int id) {
        User result = null;

        for (User user : users) {
            if (user.getId() == id) {
                result = user;
                break;
            }
        }

        return result;
    }

    @Override
    public User findLogin(String login) {
        User result = null;

        for (User user : users) {
            if (user.getLogin().equals(login)) {
                result = user;
                break;
            }
        }

        return result;
    }

    @Override
    public List<User> findByAll() {
        return users;
    }
}
