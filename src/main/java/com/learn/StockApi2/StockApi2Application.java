package com.learn.StockApi2;


import com.learn.StockApi2.Transaction.Transaction;
import com.learn.StockApi2.dao.TransactionJdbcDao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class StockApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(StockApi2Application.class, args);

//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		TransactionJdbcDao tDao = new TransactionJdbcDao(jdbcTemplate);
//		tDao.save(new Transaction(1,100,1,1));
//		List <Transaction> temp = tDao.getAll();
//		for(Transaction t: temp){
//			System.out.println(t.getStock_id() + " " + t.getQuantity());
//		}
	}
}
