package com.nasa.marsrover.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
On 2D coordinate system
Class of Coordinate saves X and Y values
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {
    private int x;
    private int y;
}
