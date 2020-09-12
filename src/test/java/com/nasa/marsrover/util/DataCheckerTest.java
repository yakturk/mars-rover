package com.nasa.marsrover.util;

import com.nasa.marsrover.exception.DataFormatExceptionHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataCheckerTest {

    @Test
    void throwsExceptionWhenFileFormatIsWrong() {
        List<String> totalReadLines = new ArrayList<>();

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkFileDataFormat(totalReadLines));

        assertTrue(exception.getMessage().contains("There is missing data."));
    }

    @Test
    void throwsExceptionWhenFileFormatIsWrong2() {
        List<String> totalReadLines = new ArrayList<>();
        totalReadLines.add("5 5");
        totalReadLines.add("1 2 N");
        totalReadLines.add("3 3 E");
        totalReadLines.add("MMRMMRMRRM");

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkFileDataFormat(totalReadLines));

        assertTrue(exception.getMessage().contains("There is missing data."));
    }

    @Test
    void notThrowsExceptionWhenFileFormatIsTrue() {
        List<String> totalReadLines = new ArrayList<>();
        totalReadLines.add("5 5");
        totalReadLines.add("1 2 N");
        totalReadLines.add("LMLMLMLMM");
        totalReadLines.add("3 3 E");
        totalReadLines.add("MMRMMRMRRM");

        DataChecker.checkFileDataFormat(totalReadLines);
    }

    @Test
    void throwsExceptionWhenPlateauDataFormatIsWrong() {
        String plateau = "5";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkPlateauData(plateau));

        assertTrue(exception.getMessage().contains("Plateau should contain only 2 numbers!"));
    }

    @Test
    void throwsExceptionWhenPlateauDataNotContainsOnlyNumbers() {
        String plateau = "5 t";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkPlateauData(plateau));

        assertTrue(exception.getMessage().contains("Plateau should contain only 2 numbers!"));
    }

    @Test
    void throwsExceptionWhenPlateauDataNotContainsOnlyNumbers2() {
        String plateau = "5 5 5";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkPlateauData(plateau));

        assertTrue(exception.getMessage().contains("Plateau should contain only 2 numbers!"));
    }

    @Test
    void notThrowsExceptionWhenPlateauDataIsTrue() {
        String plateau = "5 5";

        DataChecker.checkPlateauData(plateau);
    }

    @Test
    void throwsExceptionWhenRoverDataFormatIsWrong() {
        String roverData =  "1 2";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkRoverData(roverData));

        assertTrue(exception.getMessage().contains("Check coordinates and direction of rover!"));
    }

    @Test
    void notThrowsExceptionWhenRoverDataIsTrue() {
        String roverData =  "1 2 N";

        DataChecker.checkRoverData(roverData);
    }

    @Test
    void throwsExceptionWhenOrderDataIsWrong() {
        String orderData = "LRLRLRLRT";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkOrdersData(orderData));

        assertTrue(exception.getMessage().contains("It should contain only L, R and M!"));
    }

    @Test
    void throwsExceptionWhenOrderDataIsWrong2() {
        String orderData = "LRLR2LRLR";

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> DataChecker.checkOrdersData(orderData));

        assertTrue(exception.getMessage().contains("It should contain only L, R and M!"));
    }

    @Test
    void notThrowsExceptionWhenOrderDataIsTrue() {
        String orderData = "LRLRLRLR";

        DataChecker.checkOrdersData(orderData);
    }
}