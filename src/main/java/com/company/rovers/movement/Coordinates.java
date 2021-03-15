package com.company.rovers.movement;

import java.util.Objects;

public class Coordinates {

    long x;
    long y;

    private Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates of(long x, long y) {
        return new Coordinates(x, y);
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
