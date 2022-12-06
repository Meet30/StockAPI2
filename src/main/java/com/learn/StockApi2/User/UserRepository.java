package com.learn.StockApi2.User;

import java.util.List;

public interface UserRepository{


    List<User> getAllUsers();

    User getUser(int id);

    void addUser(User user);

    void updateUser(User user, int id);

    void deleteUser(int id);


}
