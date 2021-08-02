package andres.learning.CRUD.controller;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    //I noticed that the pool have to be inside a Servlet
    //When I try to create inside a  JAVA normal class, it does not work
    @Resource(name = "jdbc/users")
    DataSource connectionPool;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter output = response.getWriter();
        output.println("<h1>RESPONSE FROM CONTROLLER</h1>");
        DbConnection dbConnection = new DbConnection(connectionPool);
        try {
            System.out.println(dbConnection.getById(Integer.parseInt(request.getParameter("userId"))).completeUserInformation());
            System.out.println(dbConnection.getById(Integer.parseInt(request.getParameter("userId"))).userInformation());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("The user not exist");
        }
        System.out.println();*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
