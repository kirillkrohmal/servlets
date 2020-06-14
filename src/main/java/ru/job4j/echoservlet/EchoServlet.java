package ru.job4j.echoservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Comp on 06.11.2017.
 */
public class EchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserStorage.getInstance().getUsers());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/echoservlet/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final User user = new User(req.getParameter("login"), req.getParameter("email"));
        UserStorage.getInstance().add(user);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/echoview"));
    }
}

