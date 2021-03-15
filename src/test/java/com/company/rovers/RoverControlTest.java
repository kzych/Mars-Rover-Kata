package com.company.rovers;

import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldChangeDirectionIfRotatedLeft() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.NORTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        rover.rotateLeft();
        Coordinates position1L = rover.getPosition();
        Direction direction1L = rover.getDirection();

        rover.rotateLeft();
        Coordinates position2L = rover.getPosition();
        Direction direction2L = rover.getDirection();

        rover.rotateLeft();
        Coordinates position3L = rover.getPosition();
        Direction direction3L = rover.getDirection();

        rover.rotateLeft();
        Coordinates position4L = rover.getPosition();
        Direction direction4L = rover.getDirection();

        //then
        assertEquals("Rover's position should be the same as initialized", startingPoint, position1L);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position2L);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position3L);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position4L);
        assertEquals("Rover's direction should be updated when rotating", Direction.WEST, direction1L);
        assertEquals("Rover's direction should be updated when rotating", Direction.SOUTH, direction2L);
        assertEquals("Rover's direction should be updated when rotating", Direction.EAST, direction3L);
        assertEquals("Rover's direction should be updated when rotating", Direction.NORTH, direction4L);
    }

    @Test
    public void supportsRotatingLeftFromAnyDirection() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);

        //when
        for (Direction direction : Direction.values()) {
            Rover rover = new MarsRover(startingPoint, direction);
            rover.rotateLeft();
        }

        //then
        // no error
    }

    @Test
    public void shouldChangeDirectionIfRotatedRight() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.NORTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        rover.rotateRight();
        Coordinates position1R = rover.getPosition();
        Direction direction1R = rover.getDirection();

        rover.rotateRight();
        Coordinates position2R = rover.getPosition();
        Direction direction2R = rover.getDirection();

        rover.rotateRight();
        Coordinates position3R = rover.getPosition();
        Direction direction3R = rover.getDirection();

        rover.rotateRight();
        Coordinates position4R = rover.getPosition();
        Direction direction4R = rover.getDirection();

        //then
        assertEquals("Rover's position should be the same as initialized", startingPoint, position1R);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position2R);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position3R);
        assertEquals("Rover's position should be the same as initialized", startingPoint, position4R);
        assertEquals("Rover's direction should be updated when rotating", Direction.EAST, direction1R);
        assertEquals("Rover's direction should be updated when rotating", Direction.SOUTH, direction2R);
        assertEquals("Rover's direction should be updated when rotating", Direction.WEST, direction3R);
        assertEquals("Rover's direction should be updated when rotating", Direction.NORTH, direction4R);
    }

    @Test
    public void supportsRotatingRightFromAnyDirection() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);

        //when
        for (Direction direction : Direction.values()) {
            Rover rover = new MarsRover(startingPoint, direction);
            rover.rotateRight();
        }

        //then
        // no error
    }

    @Test
    public void shouldMoveForwardDirectedNorth() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.NORTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveForward();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX(),startingPoint.getY() + 1), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveForwardDirectedSouth() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.SOUTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveForward();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX(),startingPoint.getY() - 1), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveForwardDirectedWest() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.WEST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveForward();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX() - 1,startingPoint.getY()), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveForwardDirectedEast() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.EAST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveForward();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX() + 1,startingPoint.getY()), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }


    @Test
    public void shouldMoveBackwardsDirectedNorth() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.NORTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveBackwards();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX(),startingPoint.getY() - 1), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveBackwardsDirectedSouth() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.SOUTH;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveBackwards();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX(),startingPoint.getY() + 1), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveBackwardsDirectedWest() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.WEST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveBackwards();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX() + 1,startingPoint.getY()), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test
    public void shouldMoveBackwardsDirectedEast() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = Direction.EAST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveBackwards();
        Coordinates position = rover.getPosition();
        Direction direction = rover.getDirection();

        //then
        assertTrue("Rover should move", moved);
        assertEquals("Rover's position should be the updated after move",
                Coordinates.of(startingPoint.getX() - 1,startingPoint.getY()), position);
        assertEquals("Rover's direction should not change while moving", startingDirection, direction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowInstantiatingRoverWithoutStartingPoint() {

        //given
        Coordinates startingPoint = null;
        Direction startingDirection = Direction.EAST;

        //when
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //then
        // throws an exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAllowInstantiatingRoverWithoutStartingDirection() {

        //given
        Coordinates startingPoint = Coordinates.of(0, 0);
        Direction startingDirection = null;

        //when
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //then
        // throws an exception
    }

    @Test
    public void shouldNotMoveForwardIfCoordinateReachesBound() {

        //given
        Coordinates startingPoint = mock(Coordinates.class);
        when(startingPoint.canMove(anyLong(), anyLong())).thenReturn(false);
        Direction startingDirection = Direction.EAST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveForward();

        //then
        assertFalse("Rover should not move if position has not changed", moved);
    }

    @Test
    public void shouldNotMoveBackwardsIfCoordinateReachesBound() {

        //given
        Coordinates startingPoint = mock(Coordinates.class);
        when(startingPoint.canMove(anyLong(), anyLong())).thenReturn(false);
        Direction startingDirection = Direction.EAST;
        Rover rover = new MarsRover(startingPoint, startingDirection);

        //when
        boolean moved = rover.tryMoveBackwards();

        //then
        assertFalse("Rover should not move if position has not changed", moved);
    }

}