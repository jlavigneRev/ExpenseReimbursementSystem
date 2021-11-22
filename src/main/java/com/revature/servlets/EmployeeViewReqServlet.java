package com.revature.servlets;

import com.revature.Employee;
import com.revature.JSHelper;
import com.revature.Request;
import com.revature.RequestService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EmployeeViewReqServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //check if logged in as employee
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        System.out.println("got email as " + email);
        if (email != null && email != "" && role == "employee") {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            //include html
            try {
                request.getRequestDispatcher("/employeeNavBar.html").include(request, response);
                request.getRequestDispatcher("/employeeViewRequest.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);

                RequestService requestService = new RequestService();
                Employee currUser = (Employee) session.getAttribute("currUser");
                List<Request> requestList = requestService.getRequestByEmployeeId(currUser.getEmpId());
                System.out.println(requestList);
                ArrayList<String> lines;
                pw.println("<script>");
                for (Request req : requestList) {
                    //add to all table
                    lines = JSHelper.addToTableJS(req, "allTable", false, false);
                    for (String line : lines) {
                        pw.println(line);
                    }
                    if (req.isPending()) {
                        //add to pending table
                        lines = JSHelper.addToTableJS(req, "pendingTable", false ,false);
                        for (String line : lines) {
                            pw.println(line);
                        }
                    } else {
                        //add to fulfilled table
                        lines = JSHelper.addToTableJS(req, "fulfilledTable", false, false);
                        for (String line : lines) {
                            pw.println(line);
                        }
                    }
                }
                pw.println("</script>");
                pw.println(JSHelper.updateNavUsernameJS(currUser.getFirstName()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including html to employeeViewRequestServlet");
            }

            //populate tables with request data
//            RequestService requestService = new RequestService();
//            List<Request> requestList = requestService.getAllRequest();
//            PrintWriter pw = response.getWriter();
//            pw.print("<p id='yo'>Hello</p>");

        } else {
            //not logged in, send to login
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from employeeViewRequest");
            }
        }
    }
}
