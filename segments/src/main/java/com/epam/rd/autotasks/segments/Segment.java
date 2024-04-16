package com.epam.rd.autotasks.segments;


class Segment {
    double x1;
    double x2;
    double y1;
    double y2;

    public Segment(Point start, Point end) {
        if(start.getX() == end.getX() && start.getY() == end.getY() || start == null || end == null){
            throw new IllegalArgumentException();
        }
        this.x1 = start.getX();
        this.x2 = end.getX();
        this.y1 = start.getY();
        this.y2 = end.getY();
    }

    double length() {
        double distance;

        distance = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow(y2-y1, 2));

        return distance;
    }

    Point middle() {
        return new Point(((x1+x2)/2),((y1+y2)/2));
    }

    Point intersection(Segment line2) {
        double m1 = ((y2-y1)/(x2-x1));
        double m2 = ((line2.y2 - line2.y1)/(line2.x2 - line2.x1));

        if(m1 == m2 ) return null;

        double xI = ((x1*y2 - y1*x2)*(line2.x1 - line2.x2) - (x1-x2)*(line2.x1*line2.y2 - line2.y1*line2.x2))/
                ((x1-x2)*(line2.y1 - line2.y2) - (y1-y2)*(line2.x1-line2.x2));
        double yI = ((x1*y2 - y1*x2)*(line2.y1 - line2.y2) - (y1-y2)*(line2.x1*line2.y2 - line2.y1*line2.x2))/
                ((x1-x2)*(line2.y1 - line2.y2) - (y1-y2)*(line2.x1-line2.x2));

        if (xI >= Math.min(x1, x2) && xI <= Math.max(x1, x2) &&
                yI >= Math.min(y1, y2) && yI <= Math.max(y1, y2) &&
                xI >= Math.min(line2.x1, line2.x2) && xI <= Math.max(line2.x1, line2.x2) &&
                yI >= Math.min(line2.y1, line2.y2) && yI <= Math.max(line2.y1, line2.y2)) {
            return new Point(xI, yI);
        }

        return null;
    }

}
