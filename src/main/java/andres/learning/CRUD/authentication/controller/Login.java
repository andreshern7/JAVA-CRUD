package andres.learning.CRUD.authentication.controller;

import andres.learning.CRUD.authentication.controller.model.ResponseUser;
import andres.learning.CRUD.authentication.controller.model.database.DataProcessing;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Resource(name = "jdbc/users")
    DataSource connectionPool;
    DataProcessing model;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller = new Controller();
        if (controller.checkValidUser(request, response)) {
            response.sendRedirect("App"); //Its an client approach to forward
            //request.getRequestDispatcher("App").forward(request, response);
        } else {
            model = new DataProcessing(connectionPool);
            ResponseUser userToLogin = loginUser(request, response);
            if (!(userToLogin == null)) {
                Cookie validUser = new Cookie("valid.user", "VALID");
                validUser.setMaxAge(600);
                response.addCookie(validUser);
                response.sendRedirect("App");
            } else {
                response.sendRedirect("SignUp.html");
            }

        }
    }

    private ResponseUser loginUser(HttpServletRequest request, HttpServletResponse response) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseUser userToLogin = null;
        try {
            userToLogin = model.getUserLogin(username, password);
        } catch (SQLException e) {
        }
        return userToLogin;
    }

}

