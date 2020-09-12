package com.nasa.marsrover.direction;

import com.nasa.marsrover.entity.Coordinate;

public class North implements Direction{
    @Override
    public Direction turnRight() {
        return new East();
    }

    @Override
    public Direction turnLeft() {
        return  new West();
    }

    @Override
    public void move(Coordinate coordinate) {
        coordinate.setY(coordinate.getY()+1);
    }

    @Override
    public Coordinate nextMove(Coordinate coordinate) {
        return new Coordinate(coordinate.getX(), coordinate.getY()+1);
    }
}
