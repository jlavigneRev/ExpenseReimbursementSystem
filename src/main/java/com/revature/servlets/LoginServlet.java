package com.revature.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

        //include login html form
        try {
            request.getRequestDispatcher("/login.html").include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error including login.html to LoginServlet");
        }
        HttpSession session = request.getSession();
        boolean errorStatus = (boolean) session.getAttribute("loginError");
        if(errorStatus) {
            //write error message to page
            try {
                PrintWriter pw = response.getWriter();
                pw.println("<script>");
                pw.println("document.getElementById('errorMsg').innerHTML = 'Invalid login credentials'");
                pw.println("</script>");
            } catch (IOException e) {
                System.out.println("Error creating LoginServlet Printwriter");
                e.printStackTrace();
            }
        }
    }
}
