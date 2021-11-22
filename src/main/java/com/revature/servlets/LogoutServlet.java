package com.revature.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //get of session info
        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("role");
        session.removeAttribute("currUser");
        session.removeAttribute("firstName");
        //send to login
        try {
            response.sendRedirect("login");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to redirect to login from logout servlet");
        }
    }
}
