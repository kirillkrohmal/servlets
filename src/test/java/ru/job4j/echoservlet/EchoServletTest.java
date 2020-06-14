package ru.job4j.echoservlet;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.job4j.userservlet.UserServletTest;
import ru.job4j.userservlet.controller.UserCreateServlet;
import ru.job4j.userservlet.controller.UserUpdateServlet;
import ru.job4j.userservlet.controller.UsersServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.*;


@ExtendWith(MockitoExtension.class)
public class EchoServletTest {
    @Test
    public void addEcho() throws Exception {
        EchoServlet echoServlet = new EchoServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn( "email");

        echoServlet.doPost(request, response);

        List<User> userList = UserStorage.getInstance().getUsers();

        assertThat(userList.get(1).getLogin(), is("login"));
    }

    @Test
    public void getEcho() throws Exception {
        EchoServlet echoServlet = new EchoServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn( "email");

        echoServlet.doPost(request, response);

        assertThat(UserStorage.getInstance().getUsers(), is("login"));
    }
}
