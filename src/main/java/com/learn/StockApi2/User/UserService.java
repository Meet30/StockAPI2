package com.learn.StockApi2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class UserService {


    public List<User> getAllUser(){
        List <User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    public User getUser(int user_id){
        return userRepository.findById(user_id).get();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(int user_id){
        userRepository.deleteById(user_id);
    }

    public void updateUser(User user, int id){
        deleteUser(id);
        addUser(user);
    }
}
