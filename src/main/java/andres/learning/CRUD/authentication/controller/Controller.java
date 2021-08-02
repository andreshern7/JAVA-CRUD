package andres.learning.CRUD.authentication.controller;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/Controller")
public class Controller extends HttpServlet {
    /*I noticed that the pool have to be inside a Servlet
    When I try to create inside a  JAVA normal class, it does not work
    @Resource(name = "jdbc/users")
    DataSource connectionPool;*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public boolean checkValidUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] requestCookies = request.getCookies();
        boolean validUser = false;
        if (!(requestCookies == null)) {
            for (Cookie cookie : requestCookies) {
                if (cookie.getName().equals("valid.user")) {
                    if (cookie.getValue().equals("VALID")) {
                        validUser = true;
                    }
                }
            }
        }
        return validUser;
    }
}
