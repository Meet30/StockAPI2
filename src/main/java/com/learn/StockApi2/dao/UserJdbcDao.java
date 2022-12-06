package com.learn.StockApi2.dao;


import com.learn.StockApi2.Stock.Stock;
import com.learn.StockApi2.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.*;

@Component
public class UserJdbcDao implements DAO <User,Integer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    Set <Integer> convertToSet(String s){
        Set <Integer> temp = new HashSet<>();
        String arr[] = s.split(" ");
        for(String x: arr){
            temp.add(Integer.parseInt(x));
        }
        return temp;
    }

    String convertToString(Set <Integer> s){
        String ans = "";
        for(int i: s){
            ans = ans + Integer.toString(i) + " ";
        }
        return ans;
    }
    RowMapper <User> rowMapper = (rs, rowNum) -> {
        int user_id = rs.getInt("user_id");
        int balance = rs.getInt("balance");
        Set <Integer> portfolio = convertToSet(rs.getString("portfolio"));
        Set <Integer> transactions = convertToSet(rs.getString("transactions"));
        User user = new User(user_id,balance,portfolio,transactions);
        return user;
    };

    public UserJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        String sql1 = "DROP TABLE IF EXISTS users";
        String sql2 = "CREATE TABLE IF NOT EXISTS users(user_id INT, balance BIGINT,portfolio VARCHAR(1000), transactions VARCHAR(1000))";
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * from users";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void save(User u) {
        String sql = "INSERT INTO users(user_id, balance, portfolio, transactions) values (?,?,?,?)";
        int insert = jdbcTemplate.update(sql,u.getUser_id(),u.getBalance(),convertToString(u.getPortfolio()),convertToString(u.getTrasactions()));
    }

    @Override
    public User get(Integer id) {
        String sql = "SELECT * FROM  WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public void update(User u, Integer id) {
        String sql = "UPDATE users SET user_id = ?, balance = ?, portfolio = ?, transactions = ? WHERE user_id = ?";
        int rowAffected = jdbcTemplate.update(sql,u.getUser_id(),u.getBalance(),convertToString(u.getPortfolio()),convertToString(u.getTrasactions()),id);
    }

    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM users WHERE user_id = ?";
        jdbcTemplate.update(sql,id);
    }
}
