package com.revature;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class ManagerDaoImp extends DaoHelperImp implements ManagerDao{

    public ManagerDaoImp(){}

    @Override
    public void addManager(Manager manager) {
        getCurrentSession().save(manager);
    }

    @Override
    public void updateManager(Manager manager) {
        getCurrentSession().update(manager);
    }

    @Override
    public Manager getManagerById(int id) {
        Manager manager = (Manager) getCurrentSession().get(Manager.class, id);
        return manager;
    }

    @Override
    public Manager getManagerByCredentials(String email, String password) {
        Manager manager = null;
        String hql="Select man.manId from Manager man where man.email=:email and man.password=:password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List result = query.list();
        Iterator it = result.iterator();
        if(it.hasNext()){
            int id = (int) it.next();
            manager = getManagerById(id);
        }
        return manager;
    }

    @Override
    public boolean validManagerCredentials(String email, String password) {
        String hql="Select man.manId from Manager man where man.email=:email and man.password=:password";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List result = query.list();
        Iterator it = result.iterator();
        if(it.hasNext())
            return true;
        return false;
    }

    @Override
    public void deleteManager(Manager manager) {
        getCurrentSession().delete(manager);
    }

    @Override
    public List<Manager> getAllManagers() {
        List<Manager> managers = (List<Manager>) getCurrentSession().createQuery("from Manager").list();
        return managers;
    }
}
