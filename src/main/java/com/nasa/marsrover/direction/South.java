package com.nasa.marsrover.direction;

import com.nasa.marsrover.entity.Coordinate;

public class South implements Direction{
    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public void move(Coordinate coordinate) {
        coordinate.setY(coordinate.getY()-1);
    }

    @Override
    public Coordinate nextMove(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY()-1);
    }
}
