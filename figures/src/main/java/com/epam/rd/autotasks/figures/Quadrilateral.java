package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Quadrilateral(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }


    @Override
    public double area() {
        return 0.5 * Math.abs(pointA.getX()*(pointB.getY()-pointD.getY())+
                pointB.getX()*(pointC.getY()-pointA.getY())+
                pointC.getX()*(pointD.getY()-pointB.getY())+
                pointD.getX()*(pointA.getY()-pointC.getY()));

    }

    @Override
    public String pointsToString() {
        return pointA.toString()+pointB.toString()+pointC.toString()+pointD.toString();
    }

    @Override
    public Point leftmostPoint() {
        double min = Math.min(Math.min(Math.min(pointA.getX(),pointB.getX()),pointC.getX()),pointD.getX());
        if(pointA.getX() == min) return pointA;
        if(pointB.getX() == min) return pointB;
        if(pointC.getX() == min) return pointC;
        return pointD;
    }
}
