package ru.job4j.userservlet;

import org.junit.Test;
import ru.job4j.echoservlet.User;
import ru.job4j.echoservlet.UserStorage;
import ru.job4j.userservlet.controller.UserCreateServlet;
import ru.job4j.userservlet.controller.UserDeleteServlet;
import ru.job4j.userservlet.controller.UserUpdateServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServletTest {

    @Test
    public void addEcho() throws Exception {
        User user = new User("login", "email");

        UserCreateServlet usersServlet = new UserCreateServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("email");

        usersServlet.doPost(request, response);

        User userStorage = UserStorage.getInstance().add(user);

        assertThat(userStorage.getLogin(), is("login"));
    }

    @Test
    public void updateEcho() throws Exception {
        UserUpdateServlet userUpdateServlet = new UserUpdateServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("login")).thenReturn( "email");

        userUpdateServlet.doPost(request, response);

        assertThat(userUpdateServlet, is("login"));
    }

    @Test
    public void deleteEcho() throws Exception {
        UserDeleteServlet userDeleteServlet = new UserDeleteServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);

        when(request.getParameter("login")).thenReturn("email");

        userDeleteServlet.doGet(request, response);

        assertThat(UserStorage.getInstance().getUsers(),is("login"));
    }

}
