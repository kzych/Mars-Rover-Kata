package com.company.rovers.movement;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {

    @Test
    public void shouldMovePointSouth() {
        long xDiff = -1, yDiff = 0;
        doMovePointTest(xDiff, yDiff);
    }

    @Test
    public void shouldMovePointNorth() {
        long xDiff = 1, yDiff = 0;
        doMovePointTest(xDiff, yDiff);
    }

    @Test
    public void shouldMovePointWest() {
        long xDiff = 0, yDiff = -1;
        doMovePointTest(xDiff, yDiff);
    }

    @Test
    public void shouldMovePointEast() {
        long xDiff = 0, yDiff = 1;
        doMovePointTest(xDiff, yDiff);
    }

    private void doMovePointTest(long xDiff, long yDiff){
        //given
        Coordinates coordinates = Coordinates.of(0, 0);

        //when
        boolean canMove = coordinates.canMove(xDiff, yDiff);
        Coordinates moved = coordinates.moved(xDiff, yDiff);

        //then
        assertTrue(canMove);
        assertEquals(xDiff, moved.getX());
        assertEquals(yDiff, moved.getY());
    }

    @Test
    public void shouldNotAllowMovingBeyondRightBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MAX_VALUE, 0);
        long xDiff = 1, yDiff = 0;

        //when
        boolean canMove = coordinates.canMove(xDiff, yDiff);

        //then
        assertFalse(canMove);
    }

    @Test
    public void shouldNotAllowMovingBeyondLeftBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MIN_VALUE, 0);
        long xDiff = -1, yDiff = 0;

        //when
        boolean canMove = coordinates.canMove(xDiff, yDiff);

        //then
        assertFalse(canMove);
    }

    @Test
    public void shouldNotAllowMovingBeyondTopBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MAX_VALUE);
        long xDiff = 0, yDiff = 1;

        //when
        boolean canMove = coordinates.canMove(xDiff, yDiff);

        //then
        assertFalse(canMove);
    }


    @Test
    public void shouldNotAllowMovingBeyondBottomBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MIN_VALUE);
        long xDiff = 0, yDiff = -1;

        //when
        boolean canMove = coordinates.canMove(xDiff, yDiff);

        //then
        assertFalse(canMove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondBottomBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MIN_VALUE);
        long xDiff = 0, yDiff = -1;

        //when
        coordinates.moved(xDiff, yDiff);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondTopBound() {
        //given
        Coordinates coordinates = Coordinates.of(0, Long.MAX_VALUE);
        long xDiff = 0, yDiff = 1;

        //when
        coordinates.moved(xDiff, yDiff);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondLeftBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MIN_VALUE, 0);
        long xDiff = -1, yDiff = 0;

        //when
        coordinates.moved(xDiff, yDiff);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailMovingBeyondRightBound() {
        //given
        Coordinates coordinates = Coordinates.of(Long.MAX_VALUE, 0);
        long xDiff = 1, yDiff = 0;

        //when
        coordinates.moved(xDiff, yDiff);

        //then
        // exception
    }

}