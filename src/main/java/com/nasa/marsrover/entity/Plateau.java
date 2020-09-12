package com.nasa.marsrover.entity;

/*
2D coordinate System
its lower-left coordinates are always 0,0.
 */

public class Plateau {
    private final static Coordinate lowerCoordinate = new Coordinate(0,0);
    private Coordinate upperCoordinate;

    public Plateau(Coordinate coordinate){
        this.upperCoordinate = coordinate;
    }

    public static Coordinate getLowerCoordinate() {
        return lowerCoordinate;
    }

    public Coordinate getUpperCoordinate() {
        return upperCoordinate;
    }

    public void setUpperCoordinate(Coordinate upperCoordinate) {
        this.upperCoordinate = upperCoordinate;
    }
}
