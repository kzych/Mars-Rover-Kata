package com.company.rovers;

import com.company.rovers.movement.Coordinates;
import com.company.rovers.movement.Direction;

public class MarsRover implements Rover {

    private static final int VELOCITY = 1;

    private Coordinates position;
    private Direction direction;

    public MarsRover(Coordinates startingPoint, Direction startingDirection) {

        if(startingPoint == null){
            throw new IllegalArgumentException("Start point cannot be null");
        }

        if(startingDirection == null){
            throw new IllegalArgumentException("Direction cannot be null");
        }

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

    @Override
    public void rotateLeft() {
        switch(this.direction){
            case NORTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.NORTH;
                break;
            default:
                throw new IllegalStateException("Unsupported direction " + this.direction);
        }
    }

    @Override
    public void rotateRight() {
        switch(this.direction){
            case NORTH:
                this.direction = Direction.EAST;
                break;
            case EAST:
                this.direction = Direction.SOUTH;
                break;
            case SOUTH:
                this.direction = Direction.WEST;
                break;
            case WEST:
                this.direction = Direction.NORTH;
                break;
            default:
                throw new IllegalStateException("Unsupported direction " + this.direction);
        }
    }

    @Override
    public boolean tryMoveForward() {
        return doTryMove(this.direction, VELOCITY);
    }

    private boolean doTryMove(Direction direction, long velocity) {
        boolean moved = false;
        if (this.position.canMove(direction, velocity)) {
            this.position = this.position.moved(direction, velocity);
            moved = true;
        }
        return moved;
    }

    @Override
    public boolean tryMoveBackwards() {
        return doTryMove(this.direction, -1 * VELOCITY);
    }

}
