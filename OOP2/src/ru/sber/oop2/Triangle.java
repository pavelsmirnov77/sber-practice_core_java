package ru.sber.oop2;

public class Triangle extends Figure implements Drawable{
    double a;
    double b;
    double c;

    public Triangle(Point points, double a, double b, double c) {
        super(points, "треугольник");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double perimeter = perimeter()/2;
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Такого треугольника не существует!");
            return 0;
        }
        return Math.sqrt(perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));
    }

    @Override
    public double perimeter() {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Такого треугольника не существует!");
            return 0;
        }
        return a + b + c;
    }

    @Override
    public void draw(Color color) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Такого треугольника не существует!");
        }
        System.out.println(String.format("Нарисован треугольник, цвет: %s", color));
    }

    @Override
    public void draw() {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("Такого треугольника не существует!");
        }
        System.out.println("Нарисован треугольник, цвет: BLACK");
    }
}
