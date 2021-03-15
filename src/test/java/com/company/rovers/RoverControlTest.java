package com.company.rovers;

import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoverControlTest {

    @Test
    public void shouldReturnItsStartPositionIfNotMoved() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.NORTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertEquals("Rover's position should be the same as initialized", startingPoint, position);
        assertEquals("Rover's direction should be the same as initialized", startingDirection, direction);
    }
}