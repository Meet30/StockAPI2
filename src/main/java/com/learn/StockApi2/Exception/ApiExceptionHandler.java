package com.learn.StockApi2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler{
    @ExceptionHandler(value = {GetByIdAccessException.class})
    public ResponseEntity <Object> handleGetByIdAccessException(GetByIdAccessException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String help = "Call this request without id then you will get list of all entities";
        ApiException apiException = new ApiException(e.getMessage(), status, ZonedDateTime.now(),help);
        return new ResponseEntity<>(apiException,status);
    }

    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> handleEntityAlreadyExistException(EntityAlreadyExistException e){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        String help = "Try to save entity with diffrent symbol name. Symbol name of every entity shoud be unique";
        ApiException apiException = new ApiException(e.getMessage(), status, ZonedDateTime.now(),help);
        return new ResponseEntity<>(apiException,status);
    }
}
