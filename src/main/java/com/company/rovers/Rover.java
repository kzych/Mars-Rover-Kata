package com.company.rovers;

import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;

public interface Rover {

    Coordinates getPosition();
    Direction getDirection();

    void rotateLeft();
    void rotateRight();
    boolean tryMoveForward();
    boolean tryMoveBackwards();
}
