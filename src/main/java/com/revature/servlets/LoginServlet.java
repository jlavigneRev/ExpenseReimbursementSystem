package com.revature.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        //include login html form
        try {
            request.getRequestDispatcher("/login.html").include(request, response);
            HttpSession session = request.getSession();
            boolean errorStatus = (Boolean) session.getAttribute("loginError");
            if (errorStatus) {
                System.out.println("here");
                //write error message to page
                pw.println("<script>");
                pw.println("document.getElementById('errorMsg').innerHTML = 'Invalid login credentials';");
                pw.println("</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error including login.html to LoginServlet");
        }
    }
}
