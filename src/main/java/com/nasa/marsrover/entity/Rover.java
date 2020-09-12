package com.nasa.marsrover.entity;


import com.nasa.marsrover.direction.Direction;
import com.nasa.marsrover.direction.Directions;
import lombok.Data;

/*
Rover which moves on 2d coordinate system(plateau),
saves current coordinates and direction.
 */

@Data
public class Rover {
    private Coordinate coordinate;
    private Direction direction;

    public Rover(Coordinate coordinate, Direction direction){
        this.coordinate = coordinate;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return  coordinate.getX() + " " + coordinate.getY() + " " + Directions.getEnumByClass(direction);
    }
}
