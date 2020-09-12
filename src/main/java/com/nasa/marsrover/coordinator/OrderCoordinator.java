package com.nasa.marsrover.coordinator;

import com.nasa.marsrover.entity.Coordinate;
import com.nasa.marsrover.entity.Plateau;
import com.nasa.marsrover.entity.Rover;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/*
Coordinate a Rover's movements on Plateau
checking an order list for the rover.
 */

@Data
public class OrderCoordinator {
    private final static char RIGHT = 'R';
    private final static char LEFT = 'L';

    private List<Character> orders;
    private Rover rover;
    
    public OrderCoordinator(String ordersInString, Rover rover){
        orders = ordersInString.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        this.rover = rover;
    }

    public void move(Plateau plateau){
        for(int i = 0; i< orders.size(); i++){
            char currentOrder = orders.get(i);
            if(currentOrder == RIGHT){
                rover.setDirection(rover.getDirection().turnRight());
            }
            else if(currentOrder == LEFT){
                rover.setDirection(rover.getDirection().turnLeft());
            }
            else {
                if(isMoveable(plateau, rover))
                    rover.getDirection().move(rover.getCoordinate());
            }
        }
    }

    private boolean isMoveable(Plateau plateau, Rover rover){
        Coordinate nextCoordinate = rover.getDirection().nextMove(rover.getCoordinate());
        Coordinate plateauUpperCoordinate = plateau.getUpperCoordinate();
        Coordinate plateauLowerCoordinate = plateau.getLowerCoordinate();

        if(nextCoordinate.getX() > plateauUpperCoordinate.getX() ||
                nextCoordinate.getX() < plateauLowerCoordinate.getX())
            return false;
        if(nextCoordinate.getY() > plateauUpperCoordinate.getY() ||
                nextCoordinate.getY() <plateauLowerCoordinate.getY())
            return false;
        return true;
    }
}
