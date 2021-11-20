package com.revature;

import java.util.List;

public class ManagerService {
    private ManagerDaoImp managerDao;

    public ManagerService(){
        managerDao = new ManagerDaoImp();
    }

    public void addManager(Manager manager) {
        managerDao.openCurrentSessionwithTransaction();
        managerDao.addManager(manager);
        managerDao.closeCurrentSessionwithTransaction();
    }

    public void updateManager(Manager manager) {
        managerDao.openCurrentSessionwithTransaction();
        managerDao.updateManager(manager);
        managerDao.closeCurrentSessionwithTransaction();
    }

    public Manager getManagerById(int id) {
        managerDao.openCurrentSession();
        Manager manager = managerDao.getManagerById(id);
        managerDao.closeCurrentSession();
        return manager;
    }

    public Manager getManagerByCredentials(String email, String password){
        managerDao.openCurrentSession();
        Manager manager = managerDao.getManagerByCredentials(email ,password);
        managerDao.closeCurrentSession();
        return manager;
    }

    public boolean validManagerCredentials(String email, String password) {
        managerDao.openCurrentSession();
        boolean result = managerDao.validManagerCredentials(email, password);
        managerDao.closeCurrentSession();
        return result;
    }

    public void deleteManager(int id) {
        managerDao.openCurrentSessionwithTransaction();
        Manager manager = managerDao.getManagerById(id);
        managerDao.deleteManager(manager);
        managerDao.closeCurrentSessionwithTransaction();
    }

    public List<Manager> getAllManager() {
        managerDao.openCurrentSession();
        List<Manager> managers = managerDao.getAllManagers();
        managerDao.closeCurrentSession();
        return managers;
    }
}
