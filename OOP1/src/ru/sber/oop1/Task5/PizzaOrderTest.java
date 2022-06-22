package ru.sber.oop1.Task5;

public class PizzaOrderTest {
    public static void main(String[] args) {
        PizzaOrder pizzaOrder1 = new PizzaOrder("пицца 'салями'", Size.Маленькая,true,"Городской вал 26");
        PizzaOrder pizzaOrder2 = new PizzaOrder("пицца '4 сыра'", Size.Большая, false, "Мира 74");
        System.out.println(pizzaOrder1.order());
        System.out.println(pizzaOrder1.order());

        pizzaOrder2.cancel();
        System.out.println(pizzaOrder2.order());

        pizzaOrder1.cancel();

        System.out.println(pizzaOrder1.getName());

        System.out.println(pizzaOrder2.getSize());

        pizzaOrder1.setAddress("Галкинская 34");
        System.out.println(pizzaOrder1.order());


    }

}
