package com.company.rovers;

import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;

public class MarsRover implements Rover {

    private Coordinates position;
    private Direction direction;

    public MarsRover(Coordinates startingPoint, Direction startingDirection) {
        this.position = startingPoint;
        this.direction = startingDirection;
    }

    @Override
    public Coordinates getPosition() {
        return position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }
}
