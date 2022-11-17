package com.learn.StockApi2;

import com.learn.StockApi2.Transaction.Transaction;
import com.learn.StockApi2.dao.DAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StockApi2Application {

	private static DAO <Transaction> dao;

	public StockApi2Application(DAO <Transaction> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(StockApi2Application.class, args);



		// DIRECT TEST DAO CODE
//		dao.save(new Transaction("1","HDFC",0,25,2240));
//		dao.save(new Transaction("2","TATAMOTORS",0,30,480));

//
//		System.out.println("\n All Transactions -------------------\n");
//		List<Transaction> transactionList = dao.getAll();
//		for(Transaction t: transactionList){
//			System.out.println(t.getSymbol());
//		}
//
//		System.out.println("\n Get Transaction ---------------------\n");
//		System.out.println(dao.get("2").getSymbol() + " " + dao.get("2").getQuantity());
//
//		System.out.println("\n Update Transaction --------------------- \n");
//		dao.update(new Transaction("2","TATAMOTORS",0,100,480),"2");
//
//		System.out.println("\n Get Transaction ---------------------\n");
//		System.out.println(dao.get("2").getSymbol() + " " + dao.get("2").getQuantity());
//
//		System.out.println("\n Delete Transactions ----------- \n");
//		dao.delete("2");
//
//		System.out.println("\n All Transactions -------------------\n");
//		transactionList = dao.getAll();
//		for(Transaction t: transactionList){
//			System.out.println(t.getSymbol());
//		}
	}
}
