package com.revature;

import javax.persistence.*;

@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "receipt_id")
    private int receiptId;

    @ManyToOne
    @JoinColumn(name = "req_id")
    private Request request;

    @Lob
    @Column(name = "receipt_img", columnDefinition = "BLOB")
    private byte[] receiptImg;

    public Receipt(){}

    public Receipt(int receiptId, Request request, byte[] receiptImg) {
        this.receiptId = receiptId;
        this.request = request;
        this.receiptImg = receiptImg;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public byte[] getReceiptImg() {
        return receiptImg;
    }

    public void setReceiptImg(byte[] receiptImg) {
        this.receiptImg = receiptImg;
    }
}