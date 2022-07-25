package com.bharath.skills.main;

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line(Line other){
        this.start = new Point(other.start);
        this.end = new Point(other.end);
    }

    public Line deepCopy()
    {
        return new Line(this);
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) {
        Point start = new Point(2, 3);
        Point end = new Point(5, 9);

        Line line = new Line(start,end);

        Line copy = new Line(line);

        copy.start.x = 9;
        copy.end.y = 2;

        System.out.println(line);
        System.out.println(copy);

    }
}

