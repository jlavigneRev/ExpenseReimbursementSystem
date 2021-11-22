package com.revature.servlets;

import com.revature.Employee;
import com.revature.JSHelper;
import com.revature.Manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        //check if logged in as employee
        if(email != null && email != "" && role == "employee"){
            //include html
            try {
                Employee currUser = (Employee) session.getAttribute("currUser");
                request.getRequestDispatcher("/employeeNavBar.html").include(request, response);
                request.getRequestDispatcher("/about.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
                pw.println(JSHelper.updateNavUsernameJS(currUser.getFirstName()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including employeeNav html to about");
            }
        } else if(email != null && email != "" && role == "manager"){
            //logged in as manager
            try {
                Manager currUser = (Manager) session.getAttribute(("currUser"));
                request.getRequestDispatcher("/managerNavBar.html").include(request, response);
                request.getRequestDispatcher("/about.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
                pw.println(JSHelper.updateNavUsernameJS(currUser.getFirstName()));
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
