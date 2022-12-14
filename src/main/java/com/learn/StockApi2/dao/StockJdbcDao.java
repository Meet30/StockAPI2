package com.learn.StockApi2.dao;


import com.learn.StockApi2.Exception.EntityAlreadyExistException;
import com.learn.StockApi2.Exception.GetByIdAccessException;
import com.learn.StockApi2.Stock.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.*;

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
    }

    @Override
    public List<Stock> getAll() {
        String sql = "SELECT * from stocks";
        return jdbcTemplate.query(sql,rowMapper);
    }

    @Override
    public Stock get(Integer id) throws GetByIdAccessException{
        String sql = "SELECT * FROM stocks WHERE stock_id = ?";
        try{
            Stock stock = jdbcTemplate.queryForObject(sql,rowMapper,id);
            return stock;
        }
        catch(DataAccessException e){
            throw new GetByIdAccessException("Stock with ID = " + id + " not found");
        }
    }

    @Override
    public void save(Stock s) {
        try{
            String sql = "SELECT * FROM stocks WHERE symbol = ?";
            Stock stock = jdbcTemplate.queryForObject(sql,rowMapper,s.getSymbol());
            throw new EntityAlreadyExistException("Stock with symbol " + s.getSymbol() + " already exist");
        }
        catch (DataAccessException e){
            String sql = "INSERT INTO stocks(stock_id, symbol, price) values (?,?,?)";
            int insert = jdbcTemplate.update(sql, s.getStock_id(), s.getSymbol(), s.getPrice());
        }
    }

    @Override
    public void update(Stock s, Integer id) {
        String sql = "UPDATE stocks SET stock_id = ?, symbol = ?, price = ? WHERE stock_id = ?";
        int rowAffected = jdbcTemplate.update(sql,s.getStock_id(),s.getSymbol(),s.getPrice(),id);
    }

    @Override
    public void delete(Integer id){
        String sql = "DELETE FROM stocks WHERE stock_id = ?";
        jdbcTemplate.update(sql,id);
    }
}
