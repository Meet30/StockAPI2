package com.learn.StockApi2.User;

import com.learn.StockApi2.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService implements UserRepository{
    @Autowired
    private DAO<User,Integer> userDao;

    @Override
    public List<User> getAllUsers(){
        List <User> userList = new ArrayList<>();
        userDao.getAll().forEach(userList::add);
        return userList;
    }
    @Override
    public User getUser(int user_id){
        return userDao.get(user_id);
    }
    @Override
    public void addUser(User user){
        userDao.save(user);
    }
    @Override
    public void deleteUser(int user_id){
        userDao.delete(user_id);
    }
    @Override
    public void updateUser(User user, int id){
        deleteUser(id);
        addUser(user);
    }
}
