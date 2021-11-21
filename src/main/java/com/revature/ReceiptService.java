package com.revature;

import java.io.Serializable;

public class ReceiptService {
    private ReceiptDaoImp receiptDao;

    public ReceiptService(){
        receiptDao = new ReceiptDaoImp();
    }

    public Serializable addReceipt(Receipt receipt) {
        receiptDao.openCurrentSessionwithTransaction();
        Serializable id = receiptDao.addReceipt(receipt);
        receiptDao.closeCurrentSessionwithTransaction();
        return id;
    }

    public Receipt getReceiptByReqId(Serializable id) {
        receiptDao.openCurrentSession();
        Receipt receipt = receiptDao.getReceiptByReqId(id);
        receiptDao.closeCurrentSession();
        return receipt;
    }

    public void updateReceipt(Receipt receipt) {
        receiptDao.openCurrentSessionwithTransaction();
        receiptDao.updateReceipt(receipt);
        receiptDao.closeCurrentSessionwithTransaction();
    }
}
