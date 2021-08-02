package andres.learning.CRUD.controller;

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
        //response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        output.println("<h1>LOGIN SERVLET</h1>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model = new DataProcessing(connectionPool);
        PrintWriter output = response.getWriter();
        ResponseUser userToLogin = loginUser(request, response);
        if(!(userToLogin == null)){
            output.println(userToLogin);
        }else{
            output.println("That User not exist");
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
