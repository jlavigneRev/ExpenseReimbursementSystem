package com.revature;

import java.util.List;

public interface ManagerDao {
    void addManager(Manager manager);

    void updateManager(Manager manager);

    Manager getManagerById(int id);

    Manager getManagerByCredentials(String email, String password);

    boolean validManagerCredentials(String email, String password);

    void deleteManager(Manager manager);

    List<Manager> getAllManagers();
}
