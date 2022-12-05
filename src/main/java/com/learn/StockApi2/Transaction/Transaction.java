package com.learn.StockApi2.Transaction;

public class Transaction {
    private int transaction_id;
    private int quantity;
    private int stock_id;
    private int user_id;

    public Transaction(){}

    public Transaction(int transaction_id, int quantity, int stock_id, int user_id) {
        this.transaction_id = transaction_id;
        this.quantity = quantity;
        this.stock_id = stock_id;
        this.user_id = user_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
