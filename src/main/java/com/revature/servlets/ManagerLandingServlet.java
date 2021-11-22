package com.revature.servlets;

import com.revature.JSHelper;
import com.revature.Manager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ManagerLandingServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //check if logged in as manager
        HttpSession session = request.getSession();
        Manager currUser = (Manager) session.getAttribute("currUser");
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        PrintWriter pw = response.getWriter();
        System.out.println("got email as " + email);
        if(email != null && email!= "" && role == "manager") {
            //include html
            try {
                request.getRequestDispatcher("/managerNavBar.html").include(request, response);
                request.getRequestDispatcher("/managerLanding.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);
                pw.println(JSHelper.updateNavUsernameJS(currUser.getFirstName()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including html to managerLandingServlet");
            }
        } else {
            //not logged in, send to login
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from managerLanding");
            }
        }
    }
}
