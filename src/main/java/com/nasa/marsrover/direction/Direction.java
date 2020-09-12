package com.nasa.marsrover.direction;

import com.nasa.marsrover.entity.Coordinate;

/*
Provides functionality for move, turn right, turn left
and learn coordinates of next move on 2D Coordinate system
 */

public interface Direction {
    public Direction turnRight();
    public Direction turnLeft();
    public void move(Coordinate coordinate);
    public Coordinate nextMove(Coordinate coordinate);
}
