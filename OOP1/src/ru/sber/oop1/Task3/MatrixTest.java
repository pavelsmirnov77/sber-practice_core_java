package ru.sber.oop1.Task3;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 2}, {2, 5, 4, 3}});
        Matrix matrix2 = new Matrix(new int[][]{{3, 2, 5, 4}, {4, 5, 6, 7}, {7, 8, 9, 2}, {2, 5, 4, 3}});

        Matrix c = matrix1.additionMatrix(matrix2);
        c.print();

        Matrix d = matrix1.multiByNumber(3);
        d.print();

        Matrix e = matrix1.multiByMatrix(matrix2);
        e.print();
    }
}
