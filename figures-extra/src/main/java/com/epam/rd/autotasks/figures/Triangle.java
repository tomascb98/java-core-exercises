package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point a, Point b, Point c) {
        if(a == null || b == null || c == null) throw new IllegalArgumentException();

        double distance1 = distance(a,b);
        double distance2 = distance(a,c);
        double distance3 = distance(b,c);

        double angleA = Math.toDegrees(Math.acos((distance1*distance1 + distance2*distance2 - distance3*distance3)/(2*distance1*distance2)));
        double angleB = Math.toDegrees(Math.acos((distance1*distance1 - distance2*distance2 + distance3*distance3)/(2*distance1*distance3)));
        double angleC = Math.toDegrees(Math.acos((-distance1*distance1 + distance2*distance2 + distance3*distance3)/(2*distance3*distance2)));

        if((distance1+distance2 >= distance3) && (distance1+distance3 >= distance2) && (distance2+distance3 >= distance1)
                && angleA > 0 && angleB > 0 && angleC >0 && area(distance1, distance2, distance3) > 0) {
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

    public double area(double distance1, double distance2, double distance3) {
        double s = 0.5 *(distance1 + distance2 + distance3);

        return Math.sqrt(s * (s-distance1) * (s-distance2) * (s-distance3));
    }
    double area() {
        return Math.abs((pointB.getX()-pointA.getX()) * (pointC.getY()-pointA.getY()) - (pointC.getX()-pointA.getX()) * (pointB.getY()-pointA.getY()))/2;
    }

    @Override
    public Point centroid() {
        return new Point((pointA.getX()+pointB.getX()+pointC.getX())/3 , (pointA.getY()+pointB.getY()+pointC.getY())/3);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        int count = 0;
        if (figure instanceof Triangle){
            Triangle triangle = (Triangle) figure;
            for(int i=0 ; i<=3 ; i++){
                boolean flagA = true;
                boolean flagB = true;
                boolean flagC = true;

                if (triangle.pointA == pointA || triangle.pointB == pointA || triangle.pointC == pointA && flagA){
                    flagA = false;
                    count++;
                }
                if (triangle.pointA == pointB || triangle.pointB == pointB || triangle.pointC == pointB  && flagB){
                    flagB = false;
                    count++;
                }
                if (triangle.pointA == pointC || triangle.pointB == pointC || triangle.pointC == pointC  && flagC){
                    flagC = false;
                    count++;
                }
            }
        }
        return count == 3;
    }
}
