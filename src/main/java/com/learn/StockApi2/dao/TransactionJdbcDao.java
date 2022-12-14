package com.learn.StockApi2.dao;

import com.learn.StockApi2.Exception.GetByIdAccessException;
import com.learn.StockApi2.Transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TransactionJdbcDao implements DAO <Transaction,Integer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper <Transaction> rowMapper = (rs, rowNum) -> {
        int transaction_id = rs.getInt("transaction_id");
        int quantity = rs.getInt("quantity");
        int stock_id = rs.getInt("stock_id");
        int user_id = rs.getInt("user_id");
        Transaction transaction = new Transaction(transaction_id,quantity,stock_id,user_id);
        return transaction;
    };

    public TransactionJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List <Transaction> getAll() {
        String sql = "SELECT * from transactions";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Transaction get(Integer id) throws GetByIdAccessException {
        try{
            String sql = "SELECT * FROM transactions WHERE transaction_id = ?";
            return jdbcTemplate.queryForObject(sql,rowMapper,id);
        }
        catch (DataAccessException e){
            throw new GetByIdAccessException("Transaction with ID = " + id + " not found");
        }
    }

    @Override
    public void save(Transaction t) {
        String sql = "INSERT INTO transactions(transaction_id, quantity, stock_id, user_id) values (?,?,?,?)";
        int insert = jdbcTemplate.update(sql,t.getTransaction_id(),t.getQuantity(),t.getStock_id(),t.getUser_id());
    }

    @Override
    public void update(Transaction t, Integer id) {
        String sql = "UPDATE transactions SET transaction_id = ?,quantity = ?, stock_id = ?, user_id = ? WHERE transaction_id = ?";
        int rowAffected = jdbcTemplate.update(sql,t.getTransaction_id(),t.getQuantity(),t.getStock_id(),t.getUser_id(),id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM transactions WHERE transaction_id = ?";
        jdbcTemplate.update(sql,id);
    }
}
