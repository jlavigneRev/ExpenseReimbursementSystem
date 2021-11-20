package com.revature.servlets;

import com.revature.Employee;
import com.revature.EmployeeService;
import com.revature.Manager;
import com.revature.ManagerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginValidationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //reset loginError parameter
        HttpSession session = request.getSession();
        session.setAttribute("loginError", false);


        //retrieve login info from form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EmployeeService employeeService = new EmployeeService();
        ManagerService managerService = new ManagerService();

        //check if valid login (employee or manager)
        if (employeeService.validEmployeeCredentials(email, password)) {
            //login as employee
            System.out.println("Login as employee");
            Employee currUser = employeeService.getEmployeeByCredentials(email, password);
            session.setAttribute("role", "employee");
            session.setAttribute("empId", currUser.getEmpId());
            session.setAttribute("email", currUser.getEmail());
            session.setAttribute("firstName", currUser.getFirstName());
            session.setAttribute("lastName", currUser.getLastName());
            session.setAttribute("currUser", currUser);
            System.out.println(session.getAttribute("currUser"));
            //send to employee landing
            try {
                response.sendRedirect("/project1/employeeLanding");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to EmployeeLanding from LoginValidation");
            }

        } else if (managerService.validManagerCredentials(email, password)) {
            //login as manager
            System.out.println("Login as manager");
            Manager currUser = managerService.getManagerByCredentials(email, password);
            session.setAttribute("role", "manager");
            session.setAttribute("empId", currUser.getManId());
            session.setAttribute("email", currUser.getEmail());
            session.setAttribute("firstName", currUser.getFirstName());
            session.setAttribute("lastName", currUser.getLastName());
            //send to manager landing
            try {
                response.sendRedirect("/project1/managerLanding");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to managerLanding from LoginValidation");
            }

        } else {
            //invalid login credentials
            session.setAttribute("loginError", true);
            try {
                response.sendRedirect("/project1/login");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to redirect to back to login from loginValidation");
            }
        }
    }
}
