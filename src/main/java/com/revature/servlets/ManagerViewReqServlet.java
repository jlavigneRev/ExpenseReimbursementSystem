package com.revature.servlets;

import com.revature.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManagerViewReqServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        //check if logged in as manager
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String role = (String) session.getAttribute("role");
        System.out.println("got email as " + email);
        if (email != null && email != "" && role == "manager") {
            //include html
            try {
                request.getRequestDispatcher("/managerNavBar.html").include(request, response);
                request.getRequestDispatcher("/managerViewRequest.html").include(request, response);
                request.getRequestDispatcher("/footer.html").include(request, response);

                //populate tables
                RequestService requestService = new RequestService();
                Manager currUser = (Manager) session.getAttribute("currUser");
                List<Request> requestList = requestService.getAllRequest();
                System.out.println(requestList);
                ArrayList<String> lines;
                pw.println("<script>");
                for (Request req : requestList) {
                    //add to all table
                    lines = JSHelper.addToTableJS(req, "allTable", true, true);
                    for (String line : lines) {
                        pw.println(line);
                    }
                    if (req.isPending()) {
                        //add to pending table
                        lines = JSHelper.addToTableJS(req, "pendingTable", true, true);
                        for (String line : lines) {
                            pw.println(line);
                        }
                    }
                }
                pw.println("</script>");
                System.out.println(currUser.getFirstName());
                pw.println(JSHelper.updateNavUsernameJS(currUser.getFirstName()));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error including html to managerViewReqServlet");
            }
        } else {
            //not logged in, send to login
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from managerViewReq");
            }
        }
    }
}
