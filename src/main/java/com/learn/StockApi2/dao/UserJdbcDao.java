package com.learn.StockApi2.dao;

import com.learn.StockApi2.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserJdbcDao implements DAO <User,Integer> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    RowMapper <User> rowMapper = (rs, rowNum) -> {
        int id = rs.getInt("id");
    };
}
