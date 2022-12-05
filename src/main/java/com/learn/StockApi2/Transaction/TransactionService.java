package com.learn.StockApi2.Transaction;


import com.learn.StockApi2.dao.DAO;
import com.learn.StockApi2.dao.TransactionJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements TransactionRepository{

    @Autowired
    private TransactionJdbcDao transactionDAO;

    @Override
    public List<Transaction> getAllTransactions() {
        List <Transaction> transactionList = new ArrayList<>();
        transactionDAO.getAll().forEach(transactionList::add);
        return transactionList;
    }

    @Override
    public Transaction getTransaction(int id){
        return transactionDAO.get(id);
    }
    @Override
    public void addTransaction(Transaction transaction){
        transactionDAO.save(transaction);
    }
    @Override
    public void deleteTransaction(int id){
        transactionDAO.delete(id);
    }
    @Override
    public void updateTransaction(Transaction transaction, int id){
        deleteTransaction(id);
        addTransaction(transaction);
    }
}