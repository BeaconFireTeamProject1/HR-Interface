package com.example.hrinterface.AOP;

import com.example.hrinterface.exception.MyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value={MyException.class})
    public void handlerMyException(MyException e){
        System.out.println("catch an MyException by handler: "+e);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value={Exception.class})
    public void handlerException(Exception e){
        System.out.println("catch an MyException by handler: "+e);
    }

}
