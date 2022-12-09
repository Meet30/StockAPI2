package com.learn.StockApi2.Stock;


import com.learn.StockApi2.Exception.GetByIdAccessException;
import com.learn.StockApi2.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StockService{

    @Autowired
    private DAO<Stock,Integer> stockDao;


    public List<Stock> getAllStocks() {
        List <Stock> stockList = new ArrayList<>();
        stockDao.getAll().forEach(stockList::add);
        return stockList;
    }


    public Stock getStock(int id) throws GetByIdAccessException {
        return stockDao.get(id);
    }


    public void addStock(Stock stock) {
        stockDao.save(stock);
    }


    public void updateStock(Stock stock, int id) {
        stockDao.update(stock,id);
    }

    public void deleteStock(int id) {
        stockDao.delete(id);
    }
}
