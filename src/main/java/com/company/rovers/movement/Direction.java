package com.company.rovers.movement;

/**
 * Geographic aliases for directions in a Carthesian system.
 */
public enum Direction {
    NORTH(0,1),
    EAST(1,0),
    SOUTH(0,-1),
    WEST(-1,0);

    private final int xSign;
    private final int ySign;

    Direction(int xSign, int ySign) {
        this.xSign = xSign;
        this.ySign = ySign;
    }

    protected int getXSign() {
        return xSign;
    }

    protected int getYSign() {
        return ySign;
    }
}
