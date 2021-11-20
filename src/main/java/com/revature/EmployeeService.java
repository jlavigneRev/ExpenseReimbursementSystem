package com.revature;

import java.util.List;

public class EmployeeService {
    private EmployeeDaoImp employeeDao;

    public EmployeeService(){
        employeeDao = new EmployeeDaoImp();
    }

    public void addEmployee(Employee employee) {
        employeeDao.openCurrentSessionwithTransaction();
        employeeDao.addEmployee(employee);
        employeeDao.closeCurrentSessionwithTransaction();
    }

    public void updateEmployee(Employee employee) {
        employeeDao.openCurrentSessionwithTransaction();
        employeeDao.updateEmployee(employee);
        employeeDao.closeCurrentSessionwithTransaction();
    }

    public Employee getEmployeeById(int id) {
        employeeDao.openCurrentSession();
        Employee employee = employeeDao.getEmployeeById(id);
        employeeDao.closeCurrentSession();
        return employee;
    }

    public Employee getEmployeeByCredentials(String email, String password){
        employeeDao.openCurrentSession();
        Employee employee = employeeDao.getEmployeeByCredentials(email ,password);
        employeeDao.closeCurrentSession();
        return employee;
    }

    public boolean validEmployeeCredentials(String email, String password) {
        employeeDao.openCurrentSession();
        boolean result = employeeDao.validEmployeeCredentials(email, password);
        employeeDao.closeCurrentSession();
        return result;
    }

    public void deleteEmployee(int id) {
        employeeDao.openCurrentSessionwithTransaction();
        Employee employee = employeeDao.getEmployeeById(id);
        employeeDao.deleteEmployee(employee);
        employeeDao.closeCurrentSessionwithTransaction();
    }

    public List<Employee> getAllEmployee() {
        employeeDao.openCurrentSession();
        List<Employee> employees = employeeDao.getAllEmployees();
        employeeDao.closeCurrentSession();
        return employees;
    }
}
