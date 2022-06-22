package ru.sber.oop1.Task2;

public class Circle {
    int radius;
    String color;

    Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return calculateArea();
    }

    public String perimeter() {
        return calculatePerimeter();
    }

    private double calculateArea() {
        return 3.14*radius*radius;
    }

    private String calculatePerimeter() {
        return String.format("%.1f", 2*3.14*radius);
    }

    @Override
    public String toString() {
        return String.format("Радиус %s, цвет %s, площадь %s, периметр %s", radius, color, area(), perimeter());
    }
}
