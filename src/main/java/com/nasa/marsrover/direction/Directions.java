package com.nasa.marsrover.direction;

public enum Directions {
    W(new West()),
    N(new North()),
    E(new East()),
    S(new South());

    private final Direction direction;

    Directions(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public static String getEnumByClass(Direction direction){
        for(Directions directionEnum : Directions.values()){
            if(directionEnum.direction.getClass().equals(direction.getClass())) return directionEnum.name();
        }
        return null;
    }
}
