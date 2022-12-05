package com.learn.StockApi2.Stock;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository{

    List <Stock> getAllStocks();

    Stock getStock(int id);

    void addStock(Stock stock);

    void updateStock(Stock stock, int id);

    void deleteStock(int id);
}
