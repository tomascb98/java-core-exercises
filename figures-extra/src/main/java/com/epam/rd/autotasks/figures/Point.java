package com.epam.rd.autotasks.figures;

import java.util.Objects;

class Point {
    private double x;
    private double y;
    private static final double EPSILON = 1e-10;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Math.abs(point.x - x) < EPSILON && Math.abs(point.y - y) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
