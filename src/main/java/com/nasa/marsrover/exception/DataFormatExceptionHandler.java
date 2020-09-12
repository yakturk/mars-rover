package com.nasa.marsrover.exception;

import lombok.Data;

@Data
public class DataFormatExceptionHandler extends RuntimeException{
    private String message;
    public DataFormatExceptionHandler(String msg){
        this.message = msg;
    }
}
