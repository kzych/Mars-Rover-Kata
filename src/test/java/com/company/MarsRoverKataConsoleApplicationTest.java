package com.company;

import com.company.rovers.Rover;
import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarsRoverKataConsoleApplicationTest {

    @Test
    public void smokeTest() {

        //given
        String initString = "(4, 2, EAST)";
        String commandString = "FLFFFRFLB";

        //when
        Rover rover = MarsRoverKataConsoleApplication.run(initString, commandString);

        //then
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(Coordinates.of(6,4), rover.getPosition());
    }

    @Test
    public void shouldRunWithNoCommands() {

        //given
        String initString = "(4, 2, EAST)";
        String commandString = null;

        //when
        Rover rover = MarsRoverKataConsoleApplication.run(initString, commandString);

        //then
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(Coordinates.of(4,2), rover.getPosition());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectInvalidCommands() {

        //given
        String initString = "(4, 2, EAST)";
        String commandString = "FRLBX";

        //when
        Rover rover = MarsRoverKataConsoleApplication.run(initString, commandString);

        //then
        // exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectInvalidInitString() {

        //given
        String initString = "(4, 2, X)";
        String commandString = "FRLB";

        //when
        Rover rover = MarsRoverKataConsoleApplication.run(initString, commandString);

        //then
        // exception
    }
}