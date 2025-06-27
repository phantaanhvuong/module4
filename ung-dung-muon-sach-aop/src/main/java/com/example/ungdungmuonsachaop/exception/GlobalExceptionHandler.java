package com.example.ungdungmuonsachaop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OutOfBookException.class)
    public String handleOutOfBook(){
        return "error/out_of_stock";
    }
    @ExceptionHandler(InvalidBorrowCodeException.class)
    public String handleInvalidCode() {
        return "error/invalid_code";
    }

}
