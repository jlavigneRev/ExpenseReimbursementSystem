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
    public Receipt getReceiptByReqId(Serializable id) {
        String hql="Select rec.receiptId from Receipt rec where rec.reqId=:reqId";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("reqId", id);
        List result = query.list();
        Iterator it = result.iterator();
        if(it.hasNext()){
            Receipt receipt = (Receipt) it.next();
            return receipt;
        }
        return null;
    }
}
