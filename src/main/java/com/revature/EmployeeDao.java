package com.revature;

import java.util.List;

public abstract class EmployeeDao extends GenericDaoImp{
    abstract void addEmployee(Employee employee);

    abstract void updateEmployee(Employee entity);

    abstract Employee findEmployeeById(String id);

    abstract void deleteEmployee(Employee entity);

    abstract List<Employee> getAllEmployees();

    abstract void deleteAllEmployees();
}
