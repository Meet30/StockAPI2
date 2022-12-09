package com.learn.StockApi2.dao;

import com.learn.StockApi2.Transaction.Transaction;

import java.util.List;

public interface DAO <T,Key> {

    T get(Key id);
    List<T> getAll();

    void save(T t);

    void update(T t, Key id);

    // changed
    void delete(Key id);
}
