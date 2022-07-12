package reflection;

public class FigureClass {
    private final String nameSquare;
    protected String color;
    public double side;

    private double calculateArea() throws NullPointerException, IllegalArgumentException {
        System.out.print("Площадь квадрата: ");
        return side * side;
    }

    public double calculatePerimeter() throws NullPointerException, IllegalArgumentException {
        System.out.println("Периметр квадрата: ");
        return side * 4;
    }

    public FigureClass(String nameSquare, double side) {
        this.nameSquare = nameSquare;
        this.side = side;
    }

    private FigureClass(String nameSquare, String color, double side) {
        this.nameSquare = nameSquare;
        this.color = color;
        this.side = side;
    }
}
