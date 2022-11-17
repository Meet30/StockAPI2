package com.learn.StockApi2.dao;
import com.learn.StockApi2.Transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionJdbcDao implements DAO <Transaction> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper <Transaction> rowMapper = (rs, rowNum) -> {
        String id = rs.getString("id");
        String symbol = rs.getString("symbol");
        int type = rs.getInt("type");
        int quantity = rs.getInt("quantity");
        long price = rs.getLong("price");
        Transaction transaction = new Transaction(id,symbol,type,quantity,price);
        return transaction;
    };

    public TransactionJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        String sql1 = "DROP TABLE IF EXISTS transactions";
        String sql2 = "CREATE TABLE IF NOT EXISTS transactions(id varchar(20), symbol varchar(20), type INT, quantity INT, price BIGINT, PRIMARY KEY(id))";
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
    }

    @Override
    public List<Transaction> getAll() {
        String sql = "SELECT id, symbol, type, quantity, price from transactions";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void save(Transaction t) {
        String sql = "INSERT INTO transactions(id, symbol, type, quantity, price) values (?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,t.getId(),t.getSymbol(),t.getType(),t.getQuantity(),t.getPrice());
    }

    @Override
    public Transaction get(String id) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public void update(Transaction t, String id) {
        String sql = "UPDATE transactions SET id = ?, symbol = ?, type = ?, quantity = ?, price = ? WHERE id = ?;";
        int rowAffected = jdbcTemplate.update(sql,t.getId(),t.getSymbol(),t.getType(),t.getQuantity(),t.getPrice(), t.getId());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
