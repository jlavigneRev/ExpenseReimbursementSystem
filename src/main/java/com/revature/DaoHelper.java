package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface DaoHelper {
    Session openCurrentSession();

    Session openCurrentSessionwithTransaction();

    void closeCurrentSession();

    void closeCurrentSessionwithTransaction();

    Session getCurrentSession();

    void setCurrentSession(Session currentSession);

    Transaction getCurrentTransaction();

    void setCurrentTransaction(Transaction currentTransaction);
}
