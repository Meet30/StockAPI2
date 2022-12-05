package com.learn.StockApi2.Stock;


import com.learn.StockApi2.dao.StockJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StockService implements StockRepository{

    @Autowired
    private StockJdbcDao stockJdbcDao;

    @Override
    public List<Stock> getAllStocks() {
        List <Stock> stockList = new ArrayList<>();
        stockJdbcDao.getAll().forEach(stockList::add);
        return stockList;
    }

    @Override
    public Stock getStock(int id) {
        return stockJdbcDao.get(id);
    }

    @Override
    public void addStock(Stock stock) {
        stockJdbcDao.save(stock);
    }

    @Override
    public void updateStock(Stock stock, int id) {
        stockJdbcDao.update(stock,id);
    }

    @Override
    public void deleteStock(int id) {
        stockJdbcDao.delete(id);
    }
}
