package com.learn.StockApi2.Transaction;

import com.learn.StockApi2.dao.TransactionJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // INIT
    @RequestMapping(method = RequestMethod.GET, value = "/transactions/init")
    public void init(){
        transactionService.addTransaction(new Transaction(1,100,1,1));
        List <Transaction> temp = transactionService.getAllTransactions();
        for(Transaction t: temp){
            System.out.println(t.getStock_id() + " " + t.getQuantity());
        }
    }

    // GET REQUEST
    @RequestMapping(method = RequestMethod.GET, value = "/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransactions();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/transactions/{id}")
    public Transaction getTransaction(@PathVariable int id){
        return transactionService.getTransaction(id);
    }

    // POST REQUEST
    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }

    // DELETE REQUEST
    @RequestMapping(method = RequestMethod.DELETE, value = "/transactions/{id}")
    public void deleteTransaction(@PathVariable int id){
        transactionService.deleteTransaction(id);
    }

    // PUT REQUEST
    @RequestMapping(method = RequestMethod.PUT, value = "/transactions/{id}")
    public  void updateTransaction(@RequestBody Transaction transaction, @PathVariable int id){
        transactionService.updateTransaction(transaction,id);
    }
}
