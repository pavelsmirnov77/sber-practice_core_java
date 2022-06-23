package ru.sber.oop2;

public abstract class Figure {

    Point points;
    String nameFigure;

    public Figure(Point points, String nameFigure) {
        this.points = points;
        this.nameFigure = nameFigure;
    }

    public abstract double area();

    public abstract double perimeter();

}
