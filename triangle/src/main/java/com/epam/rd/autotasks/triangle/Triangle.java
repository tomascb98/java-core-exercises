package com.epam.rd.autotasks.triangle;

class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point a, Point b, Point c) {
        double distance1 = distance(a,b);
        double distance2 = distance(a,c);
        double distance3 = distance(b,c);

        double angleA = Math.toDegrees(Math.acos((distance1*distance1 + distance2*distance2 - distance3*distance3)/(2*distance1*distance2)));
        double angleB = Math.toDegrees(Math.acos((distance1*distance1 - distance2*distance2 + distance3*distance3)/(2*distance1*distance3)));
        double angleC = Math.toDegrees(Math.acos((-distance1*distance1 + distance2*distance2 + distance3*distance3)/(2*distance3*distance2)));
        System.out.println(angleA + ", " + angleB + ", " + angleC);

        if((distance1+distance2 >= distance3) && (distance1+distance3 >= distance2) && (distance2+distance3 >= distance1)
            && angleA > 0 && angleB > 0 && angleC >0) {
            this.pointA = a;
            this.pointB = b;
            this.pointC = c;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double distance (Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.getX()-p1.getX(),2) + Math.pow(p2.getY()-p1.getY(),2));
    }
    public double area() {
        double distance1 = distance(pointA,pointB);
        double distance2 = distance(pointA,pointC);
        double distance3 = distance(pointB,pointC);

        double s = 0.5 *(distance1 + distance2 + distance3);

        return Math.sqrt(s * (s-distance1) * (s-distance2) * (s-distance3));
    }

    public Point centroid(){
        double xC = (1/3d)*(pointA.getX() + pointB.getX() + pointC.getX());
        double yC = (1/3d)*(pointA.getY() + pointB.getY() + pointC.getY());

        return new Point(xC, yC);
    }

}
