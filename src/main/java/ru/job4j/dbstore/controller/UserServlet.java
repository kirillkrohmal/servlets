package ru.job4j.dbstore.controller;


import ru.job4j.dbstore.validate.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;


/**
 * Created by Comp on 06.11.2017.
 */
public class UserServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("users", this.logic.values());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/dbstore/DbViewUsers.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.append(makeAction(req) ? "action done" : "action error");

        printWriter.flush();
    }

    private boolean makeAction(HttpServletRequest req) {
        String action = req.getParameter("action");

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");

        Timestamp createDate = Timestamp.valueOf(req.getParameter("createDate"));

        if ("add".equals(action)) {
            logic.add(name, email, login, createDate);
            return true;
        }

        if ("update".equals(action)) {
            logic.update(id, name, email, login, createDate);
            return true;
        }

        if ("delete".equals(action)) {
            logic.delete(id);
            return true;
        }

        return false;
    }
}






