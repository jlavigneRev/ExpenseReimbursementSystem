package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public interface GenericDao {
    public Session openCurrentSession();

    public Session openCurrentSessionwithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionwithTransaction();

    SessionFactory getSessionFactory();

    public Session getCurrentSession();

    public void setCurrentSession(Session currentSession);

    public Transaction getCurrentTransaction();

    public void setCurrentTransaction(Transaction currentTransaction);
}
