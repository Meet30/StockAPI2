package com.learn.StockApi2.Transaction;


import com.learn.StockApi2.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private DAO<Transaction> transactionDAO;

    public List<Transaction> getAllTransaction(){
        List <Transaction> transactionList = new ArrayList<>();
        transactionDAO.getAll().forEach(transactionList::add);
        return transactionList;
    }

    public Transaction getTransaction(String id){
        return transactionDAO.get(id);
    }

    public void addTransaction(Transaction transaction){
        transactionDAO.save(transaction);
    }

    public void deleteTransaction(String id){
        transactionDAO.delete(id);
    }

    public void updateTransaction(Transaction transaction, String id){
        deleteTransaction(id);
        addTransaction(transaction);
    }
}