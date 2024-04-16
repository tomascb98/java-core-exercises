package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private double radio;
    private Point center;

    public Circle(Point center, double radio) {
        this.radio = radio;
        this.center = center;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio;
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public String toString() {
        return "Circle[" + center.toString() + radio + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX()-radio, center.getY());
    }
}
