package com.company;

import com.company.rovers.MarsRover;
import com.company.rovers.Rover;
import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarsRoverKataConsoleApplication {

    private final static String INIT_STRING_PATTERN = "^\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(WEST|EAST|SOUTH|NORTH)\\s*\\)$";
    private final static String COMMAND_STRING_PATTERN = "^[F|L|R|B]*$";

    public static void main(String[] args) {
        System.out.println("Mars Rover v1.0.0");

        if(args.length < 1 || args.length > 2) {
            printUsage();
            return;
        }

        String initString = args[0];
        String commandString = null;
        if(args.length == 2) {
            commandString = args[1];
        }

        try {
            Rover rover = run(initString, commandString);
            Coordinates position = rover.getPosition();
            System.out.println("(" + position.getX() + ", " + position.getY() + ") " + rover.getDirection());
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            printUsage();
        }
    }

    public static Rover run(String initString, String commandString){
        Pattern initStringPattern = Pattern.compile(INIT_STRING_PATTERN);
        Matcher initStringMatcher = initStringPattern.matcher(initString);

        if (!initStringMatcher.matches()) {
            throw new IllegalArgumentException("Init string is invalid " + initString);
        }

        long x = Long.parseLong(initStringMatcher.group(1));
        long y = Long.parseLong(initStringMatcher.group(2));
        Direction direction = Direction.valueOf(initStringMatcher.group(3));
        MarsRover rover = new MarsRover(Coordinates.of(x, y), direction);

        char[] commands = new char[0];
        if(commandString != null){
            if(commandString.matches(COMMAND_STRING_PATTERN)) {
                commands = commandString.toCharArray();
            } else {
                throw new IllegalArgumentException("Command string is invalid " + commandString);
            }
        }

        boolean moved = true;
        for (int i = 0; i < commands.length && moved; i++) {
            switch (commands[i]) {
                case 'L':
                    rover.rotateLeft();
                    break;
                case 'R':
                    rover.rotateRight();
                    break;
                case 'F':
                    moved = rover.tryMoveForward();
                    break;
                case 'B':
                    moved = rover.tryMoveBackwards();
                    break;
            }
        }

        if (!moved) {
            System.out.println("Rover cannot move out of map");
            throw new IllegalArgumentException("Invalid command string - Rover out of map");
        }

        return rover;
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar mars-rover (<x>, <y>, <direction>) <commands>");
        System.out.println("<x> - X coordinate of the starting position (decimal)");
        System.out.println("<y> - Y coordinate of the starting position (decimal)");
        System.out.println("<direction> - direction of the starting position: EAST, WEST, NORTH, SOUTH");
        System.out.println("<commands> - F, L, R, B");
        System.out.println("");
        System.out.println("Example: mars-rover (4, 2, EAST) FLFFFRFLB");
    }

}
