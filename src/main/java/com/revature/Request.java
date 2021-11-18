package com.revature;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "req_id")
    int reqId;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    Employee employee;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "amount")
    double amount;

    @Column(name = "pending")
    boolean pending;

    @Column(name = "date_submitted")
    Date dateSubmitted;

    @Lob
    @Column(name = "receipt_img", columnDefinition = "BLOB")
    byte[] receiptImg;

    public Request() {}


}
