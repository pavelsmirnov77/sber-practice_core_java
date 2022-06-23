package ru.sber.oop2;

public class PaintExample {
    public static void main(String[] args) {
        Point pointCircle = new Point(40,20);
        Circle circle = new Circle(pointCircle, 30);

        Point pointSquare = new Point(20,40);
        Square square = new Square(pointSquare,5);

        Point pointTriangle = new Point(10,10);
        Triangle triangle = new Triangle(pointTriangle,7,4,9);

        //несуществующий треугольник
        Point pointTriangle1 = new Point(15, 29);
        Triangle triangle1 = new Triangle(pointTriangle1, 3, 4, 10);

        Point pointRectangle = new Point(50,34);
        Rectangle rectangle = new Rectangle(pointRectangle, 4, 6);

        //круг
        circle.draw(Color.BLUE);
        circle.draw();
        System.out.println("Площадь: " + circle.area());
        System.out.println("Периметр: " + circle.perimeter());

        //квадрат
        square.draw(Color.GREEN);
        square.draw();
        System.out.println("Площадь: " + square.area());
        System.out.println("Периметр: " + square.perimeter());

        //треугольник
        triangle.draw(Color.YELLOW);
        triangle.draw();
        System.out.println("Площадь: " + triangle.area());
        System.out.println("Периметр: " + triangle.perimeter());

        //вывод периметра и площади несуществующего треугольника
        System.out.println("Площадь: " + triangle1.area());
        System.out.println("Периметр: " + triangle1.perimeter());

        //прямоугольник
        rectangle.draw(Color.RED);
        rectangle.draw();
        System.out.println("Площадь: " + rectangle.area());
        System.out.println("Периметр: " + rectangle.perimeter());
        //реализация методов класса FigureUtil
        FigureUtil.perimeter(circle);
        FigureUtil.draw(rectangle, Color.RED);
        FigureUtil.draw(triangle);
        FigureUtil.area(square);
    }
}
