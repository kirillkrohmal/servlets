package ru.job4j.userservlet.controller;



import ru.job4j.userservlet.cache.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {
    private UserStorage cache = UserStorage.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cache.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/list"));
    }
}
