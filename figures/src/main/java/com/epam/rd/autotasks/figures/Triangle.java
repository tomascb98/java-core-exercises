package com.epam.rd.autotasks.figures;

class Triangle extends Figure {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }

    @Override
    public double area() {
        double distance1 = distance(pointA,pointB);
        double distance2 = distance(pointA,pointC);
        double distance3 = distance(pointB,pointC);

        double s = 0.5 *(distance1 + distance2 + distance3);

        return Math.sqrt(s * (s-distance1) * (s-distance2) * (s-distance3));
    }

    @Override
    public String pointsToString() {
        return pointA.toString() + pointB.toString() + pointC.toString();
    }

    @Override
    public Point leftmostPoint() {
        double min = Math.min(Math.min(pointA.getX(),pointB.getX()),pointC.getX());
        if(pointA.getX() == min) return pointA;
        if(pointB.getX() == min) return pointB;
        return pointC;
    }

    public double distance (Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }
}
