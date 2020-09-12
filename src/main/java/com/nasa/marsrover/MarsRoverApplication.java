package com.nasa.marsrover;

import com.nasa.marsrover.entity.Plateau;
import com.nasa.marsrover.exception.DataFormatExceptionHandler;
import com.nasa.marsrover.util.MarsRoverUtil;
import com.nasa.marsrover.coordinator.OrderCoordinator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/*
Reads text file and calculate final
position of Rovers on 2D coordinate system(Plateau)
 */
@Slf4j
@SpringBootApplication
public class MarsRoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarsRoverApplication.class, args);

        try{
            List<String> readLines = MarsRoverUtil.readFromFile(MarsRoverApplication.class.getResourceAsStream("/input.txt"));
            Plateau plateau = MarsRoverUtil.createPlateau(readLines.get(0));
            List<OrderCoordinator> orderCoordinators = MarsRoverUtil.createOrderCoordinators(readLines);

            List<String> finalCoordinates = MarsRoverUtil.getRoversFinalCoordinates(orderCoordinators, plateau);
            print(finalCoordinates);

        } catch (DataFormatExceptionHandler e){
            log.error(e.getMessage());
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private static void print(List<String> result){
        System.out.println("Output: ");
        for(String text : result)
            System.out.println(text);
    }
}
