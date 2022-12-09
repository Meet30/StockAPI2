package com.learn.StockApi2.Exception;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException(String message){
        super(message);
    }
}
