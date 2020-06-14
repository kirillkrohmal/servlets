package ru.job4j.cruduser.validate;


import ru.job4j.cruduser.model.User;
import ru.job4j.cruduser.repository.MemoryStore;
import ru.job4j.cruduser.repository.Store;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Comp on 27.10.2018.
 */
public class ValidateService implements UserService{
    private static final ValidateService SINGLETON_INSTANCE = new ValidateService();
    private final Store logic = MemoryStore.getInstance();
    private ConcurrentHashMap<Integer, User> storage = new ConcurrentHashMap<>();

    public Collection<User> values() {
        return storage.values();
    }

    public static ValidateService getInstance() {
        return SINGLETON_INSTANCE;
    }

    @Override
    public List<User> findAll() {
        return logic.findByAll();
    }

    @Override
    public boolean add(String name, String email, String login, Timestamp createDate) {
        boolean result = false;

        if (logic.findLogin(login) == null) {
            if (validateEmail(email) || email == null) {
                logic.add(new User(name, login, email, createDate));
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean update(int id, String name, String email, String login, Timestamp createDate) {
        boolean result = false;

        if (logic.findLogin(login) == null) {
            if (validateEmail(email) || email == null) {
                logic.update(id, new User(name, login, email, createDate));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;

        if (logic.findById(id) != null) {
            logic.delete(id);
            result = true;
        }

        return result;
    }

    private boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z");
        Matcher match = pattern.matcher(email);
        return match.matches();
    }
}




