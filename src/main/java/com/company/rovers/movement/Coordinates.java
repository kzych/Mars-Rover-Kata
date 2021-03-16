package com.company.rovers.movement;

import java.util.Objects;

/**
 * Coordinates in a Carthesian system with basic move operations.
 */
public class Coordinates {

    private final long x;
    private final long y;

    private Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates of(long x, long y) {
        return new Coordinates(x, y);
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public boolean canMove(Direction direction, long distance) {
        long xDiff = direction.getXSign() * distance;
        long yDiff = direction.getYSign() * distance;

        return (xDiff > 0 ? isInUpperBound(x, xDiff) : isInLowerBound(x, xDiff)) &&
                (yDiff > 0 ? isInUpperBound(y, yDiff) : isInLowerBound(y, yDiff));
    }

    private boolean isInUpperBound(long current, long diff){
        return current <= Long.MAX_VALUE - diff;
    }

    private boolean isInLowerBound(long current, long diff){
        return current >= Long.MIN_VALUE - diff;
    }

    public Coordinates moved(Direction direction, long distance){
        if(!canMove(direction, distance)) {
            throw new IllegalArgumentException("Detected X,Y overflow attempt. " +
                    "Tried to move (" + x + "; " + y + ") by " + distance + " " + direction + " within limit " +
                    "(" + Long.MIN_VALUE + "; " + Long.MAX_VALUE + ").");
        }
        long xDiff = direction.getXSign() * distance;
        long yDiff = direction.getYSign() * distance;
        return new Coordinates(x + xDiff, y + yDiff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
