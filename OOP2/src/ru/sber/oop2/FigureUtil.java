package ru.sber.oop2;

public class FigureUtil {

    private FigureUtil(){}

    public static void area(Figure figure){
        System.out.println(String.format("Нарисован %s, площадь: %s", figure.nameFigure, figure.area()));
    }

    public static void perimeter(Figure figure){
        System.out.println(String.format("Нарисован %s, периметр: %s", figure.nameFigure, figure.perimeter()));
    }

    public static void draw(Figure figure){
        System.out.println(String.format("Нарисован %s, цвет: BLACK, точки: %s", figure.nameFigure, figure.points));
    }

    public static void draw(Figure figure, Color color){
        System.out.println(String.format("Нарисован %s, цвет: %s, точки: %s", figure.nameFigure, color, figure.points));
    }

}
