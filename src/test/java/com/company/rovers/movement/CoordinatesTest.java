package com.company.rovers.movement;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {

    @Test
    public void shouldMovePointSouth() {
        //given
        Coordinates coordinates = Coordinates.of(0, 0);
        Direction direction = Direction.SOUTH;
        long distance = 100;

        //when
        boolean canMove = coordinates.canMove(direction, distance);
        Coordinates moved = coordinates.moved(direction, distance);

        //then
        assertTrue(canMove);
        assertEquals(Coordinates.of(0, -100), moved);
    }

    @Test
    public void shouldMovePointNorth() {
        //given
        Coordinates coordinates = Coordinates.of(0, 0);
        Direction direction = Direction.NORTH;
        long distance = 100;

        //when
        boolean canMove = coordinates.canMove(direction, distance);
        Coordinates moved = coordinates.moved(direction, distance);

        //then
        assertTrue(canMove);
        assertEquals(Coordinates.of(0, 100), moved);
    }

    @Test
    public void shouldMovePointWest() {
        //given
        Coordinates coordinates = Coordinates.of(0, 0);
        Direction direction = Direction.WEST;
        long distance = 100;

        //when
        boolean canMove = coordinates.canMove(direction, distance);
        Coordinates moved = coordinates.moved(direction, distance);

        //then
        assertTrue(canMove);
        assertEquals(Coordinates.of(-100, 0), moved);
    }

    @Test
    public void shouldMovePointEast() {
        //given
        Coordinates coordinates = Coordinates.of(0, 0);
        Direction direction = Direction.EAST;
        long distance = 100;

        //when
        boolean canMove = coordinates.canMove(direction, distance);
        Coordinates moved = coordinates.moved(direction, distance);

        //then
        assertTrue(canMove);
        assertEquals(Coordinates.of(100, 0), moved);
    }

    @Test
    public void shouldNotAllowMovingBeyondEastBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MAX_VALUE, 0);
        Direction direction = Direction.EAST;
        long distance = 1;

        //when
        boolean canMove = coordinates.canMove(direction, distance);

        //then
        assertFalse(canMove);
    }

    @Test
    public void shouldNotAllowMovingBeyondWestBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MIN_VALUE, 0);
        Direction direction = Direction.WEST;
        long distance = 1;

        //when
        boolean canMove = coordinates.canMove(direction, distance);

        //then
        assertFalse(canMove);
    }

    @Test
    public void shouldNotAllowMovingBeyondNorthBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MAX_VALUE);
        Direction direction = Direction.NORTH;
        long distance = 1;

        //when
        boolean canMove = coordinates.canMove(direction, distance);

        //then
        assertFalse(canMove);
    }


    @Test
    public void shouldNotAllowMovingBeyondSouthBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MIN_VALUE);
        Direction direction = Direction.SOUTH;
        long distance = 1;

        //when
        boolean canMove = coordinates.canMove(direction, distance);

        //then
        assertFalse(canMove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondSouthBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MIN_VALUE);
        Direction direction = Direction.SOUTH;
        long distance = 1;

        //when
        coordinates.moved(direction, distance);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondNorthBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MAX_VALUE);
        Direction direction = Direction.NORTH;
        long distance = 1;

        //when
        coordinates.moved(direction, distance);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondWestBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MIN_VALUE, 0);
        Direction direction = Direction.WEST;
        long distance = 1;

        //when
        coordinates.moved(direction, distance);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondEastBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MAX_VALUE, 0);
        Direction direction = Direction.EAST;
        long distance = 1;

        //when
        coordinates.moved(direction, distance);

        //then
        // exception
    }

}