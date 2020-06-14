package ru.job4j.userservlet.controller;



import ru.job4j.userservlet.cache.UserStorage;
import ru.job4j.userservlet.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Comp on 01.11.2018.
 */
public class UserUpdateServlet extends HttpServlet {
    private AtomicInteger atomicInteger = new AtomicInteger();
    private UserStorage cache = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", cache.get(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/userservlet/UpdateUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cache.update(new User(atomicInteger.incrementAndGet(), req.getParameter("login"), req.getParameter("email")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/list"));
    }
}
