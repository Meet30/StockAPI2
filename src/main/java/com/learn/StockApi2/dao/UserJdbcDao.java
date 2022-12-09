package com.learn.StockApi2.dao;


import com.learn.StockApi2.Exception.GetByIdAccessException;
import com.learn.StockApi2.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

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


    // Creating all tables here beacause user is not dependent on stocks & transaction
    public UserJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        String sql[] = new String[6];
        sql[0] = "DROP TABLE IF EXISTS transactions";
        sql[1] = "DROP TABLE IF EXISTS stocks";
        sql[2] = "DROP TABLE IF EXISTS users";

        sql[3] = "CREATE TABLE IF NOT EXISTS users(user_id INT NOT NULL AUTO_INCREMENT, balance BIGINT,portfolio VARCHAR(1000), transactions VARCHAR(1000), PRIMARY KEY(user_id))";
        sql[4] = "CREATE TABLE IF NOT EXISTS stocks (stock_id INT NOT NULL AUTO_INCREMENT, symbol VARCHAR(20), price BIGINT, PRIMARY KEY(stock_id))";
        sql[5] = "CREATE TABLE IF NOT EXISTS transactions (transaction_id INT NOT NULL AUTO_INCREMENT, quantity INT, stock_id INT, user_id INT, PRIMARY KEY(transaction_id), FOREIGN KEY (stock_id) REFERENCES stocks(stock_id), FOREIGN KEY (user_id) REFERENCES users(user_id))";

        for(int i = 0; i < 6; i++){
            jdbcTemplate.execute(sql[i]);
        }
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * from users";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public User get(Integer id) throws GetByIdAccessException {
        try {
            String sql = "SELECT * FROM  WHERE user_id = ?";
            return jdbcTemplate.queryForObject(sql, rowMapper, id);
        }
        catch (DataAccessException e){
            throw new GetByIdAccessException("User with ID = " + id + " not found");
        }
    }

    @Override
    public void save(User u) {
        String sql = "INSERT INTO users(user_id, balance, portfolio, transactions) values (?,?,?,?)";
        int insert = jdbcTemplate.update(sql,u.getUser_id(),u.getBalance(),convertToString(u.getPortfolio()),convertToString(u.getTrasactions()));
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
