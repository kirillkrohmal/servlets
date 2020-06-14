package ru.job4j.webservlet.storage;

import ru.job4j.webservlet.model.Post;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private static AtomicInteger POST_ID = new AtomicInteger(4);
    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private static final Store INST = new Store();

    public void save(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public static Store instOf() {
        return INST;
    }
}
