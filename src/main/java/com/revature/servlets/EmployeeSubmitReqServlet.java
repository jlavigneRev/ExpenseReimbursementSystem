package com.revature.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EmployeeSubmitReqServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        //check if logged in as employee
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        System.out.println("got email as " + email);
        if(email != null && email!= "" && role == "employee") {
            //include html
            try {
                request.getRequestDispatcher("/employeeNavBar.html").include(request, response);
                request.getRequestDispatcher("/employeeSubmitRequest.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including html to employeeSubmitRequestServlet");
            }
        } else {
            //not logged in, send to login
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from employeeSubmitRequest");
            }
        }
    }
}
