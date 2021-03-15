package com.company.rovers.movement;

import java.util.Objects;

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

    public boolean canMove(long xDiff, long yDiff) {
        return (xDiff <= Long.MAX_VALUE - x) && (xDiff >= Long.MIN_VALUE - x) &&
                (yDiff <= Long.MAX_VALUE - y) && (yDiff >= Long.MIN_VALUE - y);
    }

    public Coordinates moved(long xDiff, long yDiff){
        if(!canMove(xDiff, yDiff)) {
            throw new IllegalArgumentException("Detected X,Y overflow attempt. " +
                    "Tried to move (" + x + "; " + y + ") by (" + xDiff + "; " + yDiff + ") within limit " +
                    "(" + Long.MIN_VALUE + "; " + Long.MAX_VALUE + ").");
        }
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
