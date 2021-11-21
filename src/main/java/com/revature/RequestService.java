package com.revature;

import java.io.Serializable;
import java.util.List;

public class RequestService {
    private RequestDaoImp requestDao;

    public RequestService(){
        requestDao = new RequestDaoImp();
    }

    public Serializable addRequest(Request request) {
        requestDao.openCurrentSessionwithTransaction();
        Serializable id = requestDao.addRequest(request);
        requestDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public void updateRequest(Request request) {
        requestDao.openCurrentSessionwithTransaction();
        requestDao.updateRequest(request);
        requestDao.closeCurrentSessionwithTransaction();
    }

    public void deleteRequest(int id) {
        requestDao.openCurrentSessionwithTransaction();
        Request request = requestDao.getRequestById(id);
        requestDao.deleteRequest(request);
        requestDao.closeCurrentSessionwithTransaction();
    }

    public List<Request> getAllRequest() {
        requestDao.openCurrentSession();
        List<Request> requests = requestDao.getAllRequests();
        requestDao.closeCurrentSession();
        return requests;
    }

    public List<Request> getRequestByEmployeeId(int id) {
        requestDao.openCurrentSession();
        List<Request> requests = requestDao.getRequestsByEmployeeId(id);
        requestDao.closeCurrentSession();
        return requests;
    }
}
