package com.revature;

import java.io.Serializable;

public interface ReceiptDao {
    Serializable addReceipt(Receipt receipt);

    Receipt getReceiptByReqId(Serializable id);

    void updateReceipt(Receipt receipt);
}
