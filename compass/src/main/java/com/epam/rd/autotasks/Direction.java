package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    private static int degreesNormalize(int degrees){
        if(degrees<0) degrees = 360+degrees;
        return degrees%360;
    }

    public static Direction ofDegrees(int degrees) {
        if(degrees >=360 || degrees < 0) degrees = degreesNormalize(degrees);
        Direction direction = null;
        for (Direction dir: Direction.values()) {
            if(dir.degrees == degrees) direction = dir;
        }
        return direction;
    }

    public static Direction closestToDegrees(int degrees) {
        if(degrees >=360 || degrees < 0) degrees = degreesNormalize(degrees);
        int difference = Math.abs(Direction.N.degrees - degrees);
        Direction direction = Direction.N;
        for (Direction dir: Direction.values()) {
            if(Math.abs(dir.degrees - degrees) < difference){
                difference = Math.abs(dir.degrees - degrees);
                direction = dir;
            }
        }
        return direction;
    }

    public Direction opposite() {
        int degreesToFind;
        if(degrees >= 180) degreesToFind = this.degrees-180;
        else degreesToFind = this.degrees+180;
        return ofDegrees(degreesToFind);
    }

    public int differenceDegreesTo(Direction direction) {
        int degrees1 = direction.degrees + 360;
        int degrees2 = this.degrees + 360;
        int difference = Math.abs(degrees1-degrees2);
        if (difference > 180) difference = 360 - difference;
        return difference;
    }
}
