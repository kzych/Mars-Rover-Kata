package com.company.rovers.movement;

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

    public int getXSign() {
        return xSign;
    }

    public int getYSign() {
        return ySign;
    }
}
