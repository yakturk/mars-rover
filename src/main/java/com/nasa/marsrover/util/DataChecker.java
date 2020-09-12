package com.nasa.marsrover.util;

import com.nasa.marsrover.exception.DataFormatExceptionHandler;

import java.util.List;

/*
Checks data which is written from file
 */
public class DataChecker {

    public static void checkFileDataFormat(List<String> totalReadLine){
        int lineSize = totalReadLine.size();
        if(lineSize < 3 || (lineSize -1) % 2 != 0)
            throw new DataFormatExceptionHandler("Data format exception! There is missing data.");
    }

    public static void checkPlateauData(String exactData){
        if(!exactData.matches("([0-9])\\s([0-9])"))
            throw new DataFormatExceptionHandler("Data format exception! Plateau should contain only 2 numbers!");
    }

    public static void checkRoverData(String exactData){
       if(!exactData.matches("[0-9 ]+[N|E|W|S]"))
           throw new DataFormatExceptionHandler("Data format exception! Check coordinates and direction of rover!");
    }

    public static void checkOrdersData(String orders){
        if(!orders.matches("(L|R|M)*"))
            throw new DataFormatExceptionHandler("Data format exception! Rovers's orders contain invalid character. It should contain only L, R and M!");
    }
}
