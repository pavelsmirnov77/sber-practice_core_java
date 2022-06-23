package ru.sber.oop2;

public class Rectangle extends Figure implements Drawable{

    double a;
    double b;

    public Rectangle(Point points, double a, double b) {
        super(points, "прямоугольник");
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }

    @Override
    public void draw(Color color) {
        System.out.println(String.format("Нарисован прямоугольник, цвет: %s", color));
    }

    @Override
    public void draw() {
        System.out.println("Нарисован прямоугольник, цвет: BLACK");
    }
}
