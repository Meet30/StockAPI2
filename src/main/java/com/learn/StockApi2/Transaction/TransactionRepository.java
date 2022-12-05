package com.learn.StockApi2.Transaction;

import com.learn.StockApi2.dao.TransactionJdbcDao;

import java.util.List;


public interface TransactionRepository{

    List<Transaction> getAllTransactions();

    Transaction getTransaction(int id);

    void addTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction, int id);

    void deleteTransaction(int id);


}
