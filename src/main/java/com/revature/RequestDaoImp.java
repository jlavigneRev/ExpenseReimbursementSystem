package com.revature;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RequestDaoImp extends DaoHelperImp implements RequestDao{

    RequestDaoImp(){}

    @Override
    public Serializable addRequest(Request request) {
        return getCurrentSession().save(request);
    }

    @Override
    public void updateRequest(Request request) {
        getCurrentSession().update(request);
    }

    @Override
    public Request getRequestById(int id) {
        Request request = (Request) getCurrentSession().get(Request.class, id);
        return request;
    }

    @Override
    public void deleteRequest(Request request) {
        getCurrentSession().delete(request);
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> requests = (List<Request>) getCurrentSession().createQuery("from Request").list();
        return requests;
    }

    @Override
    public List<Request> getRequestsByEmployeeId(int empId) {
        String hql="from Request req where req.employee.empId=:empId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("empId", empId);
        List<Request> requests = (List<Request>) query.list();
        return requests;
    }
}
