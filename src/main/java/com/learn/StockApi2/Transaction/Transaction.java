package com.learn.StockApi2.Transaction;


public class Transaction {
    private String id;
    private String symbol;
    private int type;

    private int quantity;
    private long price;

    public Transaction(){}

    public Transaction(String id, String symbol, int type, int quantity, long price) {
        this.id = id;
        this.symbol = symbol;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
