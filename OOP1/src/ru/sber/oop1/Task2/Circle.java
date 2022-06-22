package ru.sber.oop1;

public class Circle {
    int radius;
    String color;

    public double area(){
        return 3.14*radius*radius;
    }

    public String perimeter(){
        return String.format("%.1f", 2*3.14*radius);
    }

    Circle(int radius, String color){
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString(){
        return String.format("Радиус %s, цвет %s, площадь %s, периметр %s", radius, color, area(), perimeter());
    }
}
