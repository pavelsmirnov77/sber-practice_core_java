package ru.sber.oop2;

public class Square extends Figure implements Drawable{
    double a;

    public Square(Point points, double a) {
        super(points, "квадрат");
        this.a = a;
    }

    @Override
    public double area() {
        return Math.pow(a, 2);
    }

    @Override
    public double perimeter() {
        return 4 * a;
    }

    @Override
    public void draw(Color color) {
        System.out.println(String.format("Нарисован квадрат, цвет: %s", color));
    }

    @Override
    public void draw() {
        System.out.println("Нарисован квадрат, цвет: BLACK");
    }
}
