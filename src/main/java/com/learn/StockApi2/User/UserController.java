package com.learn.StockApi2.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


//    // INIT
//    @RequestMapping(method = RequestMethod.GET, value = "/user/init")
//    public void init(){
//        Set <Integer> stockSet = new HashSet<>();
//        stockSet.add(10);
//        stockSet.add(20);
//        Set <Integer> transactionSet = new HashSet<>();
//        transactionSet.add(3);
//        transactionSet.add(4);
//        User temp = new User(100, 999, stockSet, transactionSet);
//        userService.addUser(temp);
//    }

    // GET
    @RequestMapping(method = RequestMethod.GET, value = "/user/")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/{user_id}")
    public User getUser(@PathVariable int user_id){
        return userService.getUser(user_id);
    }

    // POST
    @RequestMapping(method = RequestMethod.POST, value = "/user/")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{user_id}")
    public void deleteUser(@PathVariable int user_id){
        userService.deleteUser(user_id);
    }

    // PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{user_id}")
    public void updateUser(@PathVariable int user_id, @RequestBody User user){
        userService.updateUser(user,user_id);
    }
}
