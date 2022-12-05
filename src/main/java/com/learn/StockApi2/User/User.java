package com.learn.StockApi2.User;

import com.learn.StockApi2.Stock.Stock;
import com.learn.StockApi2.Transaction.Transaction;

import java.util.List;
import java.util.Set;

public class User {

    private int user_id;
    private long balance;
    private Set <Integer> portfolio;
    private Set <Integer> trasactions;
    public User() {
    }

    public User(int user_id, long balance, Set<Integer> portfolio, Set<Integer> trasactions) {
        this.user_id = user_id;
        this.balance = balance;
        this.portfolio = portfolio;
        this.trasactions = trasactions;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Set<Integer> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Set<Integer> portfolio) {
        this.portfolio = portfolio;
    }

    public Set<Integer> getTrasactions() {
        return trasactions;
    }

    public void setTrasactions(Set<Integer> trasactions) {
        this.trasactions = trasactions;
    }
}
