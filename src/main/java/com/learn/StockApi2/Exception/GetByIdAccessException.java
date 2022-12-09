package com.learn.StockApi2.Exception;
import org.springframework.dao.DataAccessException;

//public class ApiRequestException extends RuntimeException{
public class GetByIdAccessException extends DataAccessException{
    public GetByIdAccessException(String message){
        super(message);
    }

    // Referred java Runtime Exception documentation
    // we can see there is different constructors are supported
    // so here I implemented two that we commonly need
}
