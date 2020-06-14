package ru.job4j.userservlet.controller;



import ru.job4j.userservlet.cache.UserStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Comp on 23.09.2018.
 */
public class UsersServlet extends HttpServlet {
    private final UserStorage cache = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", this.cache.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/userservlet/UserView.jsp");

        dispatcher.forward(req, resp);
    }
}
