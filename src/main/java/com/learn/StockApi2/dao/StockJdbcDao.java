package com.learn.StockApi2.dao;


import com.learn.StockApi2.Stock.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockJdbcDao implements DAO <Stock,Integer> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper <Stock> rowMapper = (rs, rowNum) -> {
        int stock_id = rs.getInt("stock_id");
        String symbol = rs.getString("symbol");
        int price = rs.getInt("price");

        Stock stock = new Stock(stock_id,symbol,price);
        return stock;
    };

    public StockJdbcDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        String sql1 = "DROP TABLE IF EXISTS stocks";
        String sql2 = "CREATE TABLE IF NOT EXISTS stocks(stock_id INT, symbol VARCHAR(20), price BIGINT)";
        jdbcTemplate.execute(sql1);
        jdbcTemplate.execute(sql2);
    }

    @Override
    public List<Stock> getAll() {
        String sql = "SELECT * from stocks";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public void save(Stock s) {
        String sql = "INSERT INTO stocks(stock_id, symbol, price) values (?,?,?)";
        int insert = jdbcTemplate.update(sql,s.getPrice(),s.getSymbol(),s.getPrice());
    }

    @Override
    public Stock get(Integer id) {
        String sql = "SELECT * FROM stocks WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public void update(Stock s, Integer id) {
        String sql = "UPDATE stocks SET stock_id = ?, symbol = ?, price = ? WHERE stock_id = ?";
        int rowAffected = jdbcTemplate.update(sql,s.getStock_id(),s.getSymbol(),s.getPrice(),id);
    }

    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM stocks WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }
}
