package ru.sber.oop1.Task5;

public class PizzaOrder {
    String name;
    Size size;
    boolean sauce;
    String address;
    boolean acceptOrder = false;
    private int count;

    PizzaOrder(String name, Size size, boolean sauce, String address) {
        this.name = name;
        this.size = size;
        this.sauce = sauce;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String order() {
        acceptOrder = true;
        count += 1;
        if (count <= 1) {
            if (sauce == false) {
                return String.format("Заказ принят. %s %s без соуса на адрес %s", size, name, address);
            } else return String.format("Заказ принят. %s %s с соусом на адрес %s", size, name, address);
        }
        else return "Заказ уже принят";

    }
    public void cancel() {
        if (acceptOrder == false) {
            System.out.println("Заказ не был принят");
        }
        else {
            System.out.println("Заказ отменен");
            acceptOrder = false;
            count = 0;
        }
    }

}
