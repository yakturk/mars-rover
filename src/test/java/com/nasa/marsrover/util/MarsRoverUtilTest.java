package com.nasa.marsrover.util;

import com.nasa.marsrover.coordinator.OrderCoordinator;
import com.nasa.marsrover.direction.East;
import com.nasa.marsrover.direction.North;
import com.nasa.marsrover.entity.Plateau;
import com.nasa.marsrover.entity.Rover;
import com.nasa.marsrover.exception.DataFormatExceptionHandler;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverUtilTest {

    @Test
    void shouldParseFile() {
        InputStream testFileInputStream = getClass().getResourceAsStream("/testInput.txt");
        List<String> readLines= MarsRoverUtil.readFromFile(testFileInputStream);
        String expectedOne = "5 5";
        String expectedTwo = "1 2 N";
        String expectedThree = "LMLMLMLMM";
        String expectedFour = "3 3 E";
        String expectedFive = "MMRMMRMRRM";

        assertEquals(5, readLines.size());
        assertEquals(expectedOne, readLines.get(0));
        assertEquals(expectedTwo, readLines.get(1));
        assertEquals(expectedThree, readLines.get(2));
        assertEquals(expectedFour, readLines.get(3));
        assertEquals(expectedFive, readLines.get(4));
    }

    @Test
    void throwsExceptionWhenFileNotExist() {
        InputStream testFileInputStream = getClass().getResourceAsStream("/testInput2.txt");

        Exception exception = assertThrows(DataFormatExceptionHandler.class,
                ()-> MarsRoverUtil.readFromFile(testFileInputStream));

        assertTrue(exception.getMessage().contains("Please check the file name."));
    }

    @Test
    void shouldCreatePlateau() {
        String plateauCoordinates = "5 5";
        Plateau plateau = MarsRoverUtil.createPlateau(plateauCoordinates);

        assertEquals(5, plateau.getUpperCoordinate().getX());
        assertEquals(5, plateau.getUpperCoordinate().getY());
    }

    @Test
    void shouldCreateOrderCoordinators() {
        List<String> roversAndOrdersData = new ArrayList<>();
        roversAndOrdersData.add("5 5");
        roversAndOrdersData.add("1 2 N");
        roversAndOrdersData.add("LMLMLMLMM");
        roversAndOrdersData.add("3 3 E");
        roversAndOrdersData.add("MMRMMRMRRM");

        List<OrderCoordinator>  orderCoordinators = MarsRoverUtil.createOrderCoordinators(roversAndOrdersData);

        assertEquals(2, orderCoordinators.size());
        OrderCoordinator orderCoordinator1 = orderCoordinators.get(0);
        OrderCoordinator orderCoordinator2 = orderCoordinators.get(1);

        Rover rover1 = orderCoordinator1.getRover();
        assertEquals(1, rover1.getCoordinate().getX());
        assertEquals(2, rover1.getCoordinate().getY());
        assertEquals(North.class, rover1.getDirection().getClass());

        Rover rover2 = orderCoordinator2.getRover();
        assertEquals(3, rover2.getCoordinate().getX());
        assertEquals(3, rover2.getCoordinate().getY());
        assertEquals(East.class, rover2.getDirection().getClass());

        List<Character> orders1= orderCoordinator1.getOrders();
        List<Character> expected1 = "LMLMLMLMM".chars().mapToObj(e->(char)e).collect(Collectors.toList());
        assertEquals(expected1, orders1);

        List<Character> orders2= orderCoordinator2.getOrders();
        List<Character> expected2 = "MMRMMRMRRM".chars().mapToObj(e->(char)e).collect(Collectors.toList());
        assertEquals(expected2, orders2);
    }

    @Test
    void shouldGetRoversFinalCoordinates() {
        List<String> roversAndOrdersData = new ArrayList<>();
        roversAndOrdersData.add("5 5");
        roversAndOrdersData.add("1 2 N");
        roversAndOrdersData.add("LMLMLMLMM");
        roversAndOrdersData.add("3 3 E");
        roversAndOrdersData.add("MMRMMRMRRM");

        List<OrderCoordinator>  orderCoordinators = MarsRoverUtil.createOrderCoordinators(roversAndOrdersData);
        Plateau plateau = MarsRoverUtil.createPlateau("5 5");

        List<String> finalCoordinates = MarsRoverUtil.getRoversFinalCoordinates(orderCoordinators, plateau);

        assertEquals(2, finalCoordinates.size());
        assertEquals("1 3 N", finalCoordinates.get(0));
        assertEquals("5 1 E", finalCoordinates.get(1));
    }
}