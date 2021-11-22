package com.revature;

import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class ReceiptDaoImp extends DaoHelperImp implements ReceiptDao{
    @Override
    public Serializable addReceipt(Receipt receipt) {
        return getCurrentSession().save(receipt);
    }

    @Override
    public Receipt getReceiptByReqId(int reqId) {
        String hql="from Receipt rec where rec.request.reqId=:reqId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("reqId", reqId);
        List<Receipt> receipts = (List<Receipt>) query.list();
        return receipts.get(0);
    }

    @Override
    public void updateReceipt(Receipt receipt) {
        getCurrentSession().update(receipt);
    }
}
