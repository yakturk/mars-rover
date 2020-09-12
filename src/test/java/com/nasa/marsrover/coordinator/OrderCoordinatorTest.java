package com.nasa.marsrover.coordinator;

import com.nasa.marsrover.direction.North;
import com.nasa.marsrover.entity.Coordinate;
import com.nasa.marsrover.entity.Plateau;
import com.nasa.marsrover.entity.Rover;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class OrderCoordinatorTest {

    @Test
    void move() {
        Rover rover = new Rover(new Coordinate(1, 2), new North());
        OrderCoordinator orderCoordinator = new OrderCoordinator("LMLMLMLMM", rover);
        Plateau plateau = new Plateau(new Coordinate(5, 5));

        orderCoordinator.move(plateau);

        assertEquals(1, rover.getCoordinate().getX());
        assertEquals(3, rover.getCoordinate().getY());
        assertEquals(North.class, rover.getDirection().getClass());
    }
}