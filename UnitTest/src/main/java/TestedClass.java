public class TestedClass extends Figure {
    public double areaCylinder(double r, double h) {
        return multiplication(perimeterCircle(r), summation(r, h));
    }

    public double volumeCylinder(double r, double h) {
        return multiplication(areaCircle(r), h);
    }

    private String getFigureName() {
        return "Cylinder";
    }

}
