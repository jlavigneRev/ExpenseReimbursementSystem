package com.revature.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class RequestApprovalServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Post received");

        String reqId =  request.getParameter("reqId");
        System.out.println("Received reqId of " + reqId);
        String approved = request.getParameter("approved");
        System.out.println("Approved: " + approved);
    }
}
