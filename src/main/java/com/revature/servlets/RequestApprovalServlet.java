package com.revature.servlets;

import com.revature.Request;
import com.revature.RequestService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestApprovalServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Post received");
        RequestService requestService = new RequestService();
        int reqId =  Integer.parseInt(request.getParameter("reqId"));
        boolean approved = Boolean.parseBoolean(request.getParameter("approved"));
        Request req = requestService.getRequestById(reqId);

        if(approved){
            System.out.println("approved");
            req.setPending(false);
            requestService.updateRequest(req);
        } else {
            System.out.println("denied");
            requestService.deleteRequest(reqId);
        }
    }
}
