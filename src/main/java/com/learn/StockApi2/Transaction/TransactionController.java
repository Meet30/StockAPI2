package com.learn.StockApi2.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // GET REQUEST
    @RequestMapping(method = RequestMethod.GET, value = "/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/transactions/{id}")
    public Transaction getTransaction(@PathVariable String id){
        return transactionService.getTransaction(id);
    }

    // POST REQUEST
    @RequestMapping(method = RequestMethod.POST, value = "/transactions")
    public void addTransaction(@RequestBody Transaction transaction){
        transactionService.addTransaction(transaction);
    }

    // DELETE REQUEST
    @RequestMapping(method = RequestMethod.DELETE, value = "/transactions/{id}")
    public void deleteTransaction(@PathVariable String id){
        transactionService.deleteTransaction(id);
    }

    // PUT REQUEST
    @RequestMapping(method = RequestMethod.PUT, value = "/transactions/{id}")
    public  void updateTransaction(@RequestBody Transaction transaction, @PathVariable String id){
        transactionService.updateTransaction(transaction,id);
    }
}
