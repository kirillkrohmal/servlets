package ru.job4j.cruduser.repository;




import ru.job4j.cruduser.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * в том что хранилище создай потоко безопасную коллекцию
 *
 * и имплеменнтируй интерфейс сторе
 *
 * в валидаторе нужно сделать проверки
 *
 * например перед сохранением пользователя проверить что имя и емаил уникальны и не пустые
 *
 * и потом вызвать метод добавления из хранилища и сохранить пользователя
 *
 * или вернуть ответ что логин или емаил занят
 */
public class MemoryStore implements Store {
    private static final MemoryStore SINGLETON_INSTANCE = new MemoryStore();
    private final List<User> users = new CopyOnWriteArrayList<>();

    public static MemoryStore getInstance() {
        return SINGLETON_INSTANCE;
    }

    @Override
    public void add(User user) {
        this.users.add(user);
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
