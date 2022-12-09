package com.learn.StockApi2.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController{

    @Autowired
    private StockService stockService;

    // GET ALL
    @RequestMapping(method = RequestMethod.GET, value = "/stock/")
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }
    // GET BY ID
    @RequestMapping(method = RequestMethod.GET, value = "/stock/{stock_id}")
    public Stock getStock(@PathVariable int stock_id){
        return stockService.getStock(stock_id);
    }



    // POST
    @RequestMapping(method = RequestMethod.POST, value = "/stock")
    public void addStock(@RequestBody Stock stock){
        stockService.addStock(stock);
    }

    // PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/stock/{stock_id}")
    public void updateStock(@RequestBody Stock stock,@PathVariable int stock_id){
        stockService.updateStock(stock, stock_id);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/stock/{stock_id}")
    public void deleteStock(@PathVariable int stock_id){
        stockService.deleteStock(stock_id);
    }

}
