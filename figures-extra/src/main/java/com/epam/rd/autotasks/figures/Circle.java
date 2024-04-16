package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private double radio;
    private Point center;

    public Circle(Point center, double radio) {
        if(area(radio) > 0 && center != null && radio > 0) {
            this.radio = radio;
            this.center = center;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double area(double radio) {
        return Math.PI * radio * radio;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if( figure instanceof Circle){
            Circle circle = (Circle) figure;
            double delta = 0.0001;
            return (Math.abs(circle.center.getX() - center.getX()) <= delta &&
                    Math.abs(circle.center.getY() - center.getY()) <= delta &&
                    Math.abs(circle.radio - this.radio) <= delta);
        }
        return false;
    }
}
