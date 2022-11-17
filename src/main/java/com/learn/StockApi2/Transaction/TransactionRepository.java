package com.learn.StockApi2.Transaction;

import com.learn.StockApi2.dao.TransactionJdbcDao;

import java.util.List;


public interface TransactionRepository{

    List<Transaction> getAllTransanctions();

    Transaction getTransaction(String id);

    void addTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction, String id);

    void deleteTransaction(String id);


}
