package com.epam.rd.autotasks.intersection;

public class Line {
    private int k;
    private int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line line2) {
        if(line2.k == k) return null;

        int x = (line2.b - b)/(k - line2.k);

        int y1 = k*x+b;
        int y2 = line2.k*x + line2.b;

        if(y1==y2){
            return new Point(x , y1);
        } else {
            return null;
        }
    }

}
