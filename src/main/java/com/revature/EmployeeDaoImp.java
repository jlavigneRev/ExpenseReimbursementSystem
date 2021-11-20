package com.revature;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class EmployeeDaoImp extends DaoHelperImp implements EmployeeDao{

    public EmployeeDaoImp(){}

    @Override
    public void addEmployee(Employee employee) {
        getCurrentSession().save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        getCurrentSession().update(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = (Employee) getCurrentSession().get(Employee.class, id);
        return employee;
    }

    @Override
    public Employee getEmployeeByCredentials(String email, String password) {
        Employee employee = null;
        String hql="Select emp.empId from Employee emp where emp.email=:email and emp.password=:password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List result = query.list();
        Iterator it = result.iterator();
        if(it.hasNext()){
            int id = (int) it.next();
            employee = getEmployeeById(id);
        }
        return employee;
    }

    @Override
    public boolean validEmployeeCredentials(String email, String password) {
        String hql="Select emp.empId from Employee emp where emp.email=:email and emp.password=:password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List result = query.list();
        Iterator it = result.iterator();
        if(it.hasNext())
            return true;
        return false;
    }


    @Override
    public void deleteEmployee(Employee employee) {
        getCurrentSession().delete(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = (List<Employee>) getCurrentSession().createQuery("from Employee").list();
        return employees;
    }
}
