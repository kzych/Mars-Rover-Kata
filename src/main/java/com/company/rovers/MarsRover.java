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
        int xDiff = direction.getXSign() * VELOCITY;
        int yDiff = direction.getYSign() * VELOCITY;

        return doTryMove(xDiff, yDiff);
    }

    private boolean doTryMove(int xDiff, int yDiff) {
        boolean moved = false;
        if (this.position.canMove(xDiff, yDiff)) {
            this.position = this.position.moved(xDiff, yDiff);
            moved = true;
        }
        return moved;
    }

    @Override
    public boolean tryMoveBackwards() {
        int xDiff = -1 * direction.getXSign() * VELOCITY;
        int yDiff = -1 * direction.getYSign() * VELOCITY;

        return doTryMove(xDiff, yDiff);
    }

}
