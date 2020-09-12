package com.nasa.marsrover.util;

import com.nasa.marsrover.coordinator.OrderCoordinator;
import com.nasa.marsrover.entity.Coordinate;
import com.nasa.marsrover.entity.Plateau;
import com.nasa.marsrover.direction.Direction;
import com.nasa.marsrover.direction.Directions;
import com.nasa.marsrover.entity.Rover;
import com.nasa.marsrover.exception.DataFormatExceptionHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Provides methods to realize main operations
 */

@Slf4j
public class MarsRoverUtil {

    public static List<String> readFromFile(InputStream fileDirectory) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileDirectory))) {
            List<String> fileLines = new ArrayList<>();
            String fileLine;

            while ((fileLine = bufferedReader.readLine()) != null) {
                if(!fileLine.trim().isEmpty())
                    fileLines.add(fileLine.trim());
            }
            bufferedReader.close();
            DataChecker.checkFileDataFormat(fileLines);

            return fileLines;
        }
        catch (NullPointerException e){
            throw new DataFormatExceptionHandler("Exception occurred while reading file. Please check the file name.");
        } catch (IOException e){
            log.error("Exception occurred while reading file. Please check the file details.");
        }

        return null;
    }

    public static Plateau createPlateau(String plateauCoordinates){
       DataChecker.checkPlateauData(plateauCoordinates);

       String[] coordinatesSplitted= plateauCoordinates.split(" ");
       int x = Integer.parseInt(coordinatesSplitted[0]);
       int y = Integer.parseInt(coordinatesSplitted[1]);

       return  new Plateau(createCoordinate(x, y));
    }

    private static Rover createRover(String roverData){
        DataChecker.checkRoverData(roverData);

        String[] splittedData= roverData.split(" ");
        int x = Integer.parseInt(splittedData[0].trim());
        int y = Integer.parseInt(splittedData[1].trim());
        String direction = splittedData[2].trim();

        return new Rover(createCoordinate(x,y), createDirection(direction));
    }

    public static List<OrderCoordinator> createOrderCoordinators(List<String> roversAndOrdersData){
        List<OrderCoordinator> orderCoordinators = new ArrayList<>();
        for(int i=1; i<roversAndOrdersData.size(); i+=2){
            String orders = roversAndOrdersData.get(i+1);
            DataChecker.checkOrdersData(orders);

            orderCoordinators.add(new OrderCoordinator(orders,
                    createRover(roversAndOrdersData.get(i))));
        }
        return orderCoordinators;
    }

    public static List<String> getRoversFinalCoordinates(List<OrderCoordinator> orderCoordinators, Plateau plateau){
        List<String> currentPositions = new ArrayList<>();
        for(OrderCoordinator orderCoordinator : orderCoordinators){
            orderCoordinator.move(plateau);
            currentPositions.add(orderCoordinator.getRover().toString());
        }
        return currentPositions;
    }

    private static Direction createDirection(String direction){
        return Directions.valueOf(direction).getDirection();
    }

    private static Coordinate createCoordinate(int x, int y){
        return new Coordinate(x,y);
    }
}
