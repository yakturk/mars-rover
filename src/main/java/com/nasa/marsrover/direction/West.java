package com.nasa.marsrover.direction;

import com.nasa.marsrover.entity.Coordinate;

public class West implements Direction{
    @Override
    public Direction turnRight() {
        return new North();
    }

    @Override
    public Direction turnLeft() {
        return new South();
    }

    @Override
    public void move(Coordinate coordinate) {
        coordinate.setX(coordinate.getX()-1);
    }
    @Override
    public Coordinate nextMove(Coordinate coordinate) {
        return new Coordinate(coordinate.getX()-1, coordinate.getY());
    }
}
