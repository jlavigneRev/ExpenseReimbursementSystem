package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        //check if logged in as employee
        if(email != null && email != "" && role == "employee"){
            //include html
            try {
                request.getRequestDispatcher("/employeeNavBar.html").include(request, response);
                request.getRequestDispatcher("/about.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including employeeNav html to about");
            }
        } else if(email != null && email != "" && role == "manager"){
            //logged in as manager
            try {
                request.getRequestDispatcher("/managerNavBar.html").include(request, response);
                request.getRequestDispatcher("/about.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including managerNav html to about");
            }
        } else {
            //not logged in, send to login
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from about");
            }
        }
    }
}
