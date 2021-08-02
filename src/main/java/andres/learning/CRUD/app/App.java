package andres.learning.CRUD.app;

import andres.learning.CRUD.authentication.controller.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "App", value = "/App")
public class App extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller = new Controller();
        PrintWriter output = response.getWriter();
        if(controller.checkValidUser(request, response)){
            output.println("WELCOME TO MY PC ACCESSORIES MARKETPLACE");
        }else{
            response.sendRedirect("Login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
