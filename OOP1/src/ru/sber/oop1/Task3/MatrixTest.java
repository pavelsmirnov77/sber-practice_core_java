package ru.sber.oop1.Task3;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 2}, {2, 5, 4, 3}});
        Matrix matrix2 = new Matrix(new int[][]{{3, 1, 5, 3}, {3, 4, 5, 6}, {2, 4, 3, 1}, {2, 4, 5, 3}});

        Matrix matrix3 = matrix1.additionMatrix(matrix2);
        matrix3.print();

        Matrix matrix4 = matrix1.multiByNumber(3);
        matrix4.print();

        Matrix matrix5 = matrix1.multiByMatrix(matrix2);
        matrix5.print();
    }
}
