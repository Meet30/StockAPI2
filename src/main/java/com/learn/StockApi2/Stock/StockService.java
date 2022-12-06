package com.learn.StockApi2.Stock;


import com.learn.StockApi2.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StockService implements StockRepository{

    @Autowired
    private DAO<Stock,Integer> stockDao;

    @Override
    public List<Stock> getAllStocks() {
        List <Stock> stockList = new ArrayList<>();
        stockDao.getAll().forEach(stockList::add);
        return stockList;
    }

    @Override
    public Stock getStock(int id) {
        return stockDao.get(id);
    }

    @Override
    public void addStock(Stock stock) {
        stockDao.save(stock);
    }

    @Override
    public void updateStock(Stock stock, int id) {
        stockDao.update(stock,id);
    }

    @Override
    public void deleteStock(int id) {
        stockDao.delete(id);
    }
}
