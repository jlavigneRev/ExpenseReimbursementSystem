package com.revature;

import java.util.List;

public interface EmployeeDao{
    void addEmployee(Employee employee);

    void updateEmployee(Employee entity);

    Employee getEmployeeById(int id);

    Employee getEmployeeByCredentials(String email, String password);

    boolean validEmployeeCredentials(String email, String password);

    void deleteEmployee(Employee entity);

    List<Employee> getAllEmployees();
}
