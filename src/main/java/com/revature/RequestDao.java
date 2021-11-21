package com.revature;

import java.io.Serializable;
import java.util.List;

public interface RequestDao {
    Serializable addRequest(Request request);

    void updateRequest(Request entity);

    Request getRequestById(int id);

    void deleteRequest(Request entity);

    List<Request> getAllRequests();

    List<Request> getRequestsByEmployeeId(int id);
}
