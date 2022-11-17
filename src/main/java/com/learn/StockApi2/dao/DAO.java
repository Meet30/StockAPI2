package com.learn.StockApi2.dao;

import com.learn.StockApi2.Transaction.Transaction;

import java.util.List;

public interface DAO <T> {

    Transaction get(String id);
    List<T> getAll();

    void save(T t);

    void update(T t, String id);

    void delete(String id);
}
