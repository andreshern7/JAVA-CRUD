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
import java.io.UnsupportedEncodingException;

@WebServlet(name = "SignUp", value = "/SignUp")
public class SignUp extends HttpServlet {

    @Resource(name = "jdbc/users")
    DataSource connectionPool;
    DataProcessing model;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        model = new DataProcessing(connectionPool);
        PrintWriter output = response.getWriter();
        output.println(SignUpUser(request, response));
    }

    private ResponseUser SignUpUser(HttpServletRequest request, HttpServletResponse response) {

        ResponseUser userResponse = null;
        try {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            request.setCharacterEncoding("UTF-8");
            String lastName = request.getParameter("lastName");
            request.setCharacterEncoding("UTF-8");
            String username = request.getParameter("username");
            request.setCharacterEncoding("UTF-8");
            String password = request.getParameter("password");
            request.setCharacterEncoding("UTF-8");
            String country = request.getParameter("country");
            request.setCharacterEncoding("UTF-8");
            String technology = request.getParameter("technology");
            userResponse = model.createUser(name, lastName, username, password, country, technology);
            System.out.println(userResponse);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return userResponse;
    }
}
