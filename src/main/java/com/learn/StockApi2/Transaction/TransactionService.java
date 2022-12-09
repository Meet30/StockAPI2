package com.learn.StockApi2.Transaction;


import com.learn.StockApi2.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactionService{

    @Autowired
    private DAO <Transaction,Integer> transactionDAO;


    public List<Transaction> getAllTransactions() {
        List <Transaction> transactionList = new ArrayList<>();
        transactionDAO.getAll().forEach(transactionList::add);
        return transactionList;
    }


    public Transaction getTransaction(int id){
        return transactionDAO.get(id);
    }

    public void addTransaction(Transaction transaction){
        transactionDAO.save(transaction);
    }

    public void deleteTransaction(int id){
        transactionDAO.delete(id);
    }

    public void updateTransaction(Transaction transaction, int id){
        deleteTransaction(id);
        addTransaction(transaction);
    }
}