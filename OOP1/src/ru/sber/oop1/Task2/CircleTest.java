package ru.sber.oop1.Task2;

import ru.sber.oop1.Task2.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle bigCircle = new Circle(10, "yellow");
        Circle smallCircle = new Circle(5,"blue");

        System.out.println(bigCircle.area());
        System.out.println(smallCircle.area());

        System.out.println(bigCircle.perimeter());
        System.out.println(smallCircle.perimeter());

        System.out.println(bigCircle.toString());
        System.out.println(smallCircle.toString());
    }
}
