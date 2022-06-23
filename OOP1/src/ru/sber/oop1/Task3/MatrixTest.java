package ru.sber.oop1.Task3;

public class MatrixTest {
    public static void main(String[] args) {
        Matrix firstMatrix = new Matrix(new int[][]{{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 2}, {2, 5, 4, 3}});
        Matrix secondMatrix = new Matrix(new int[][]{{3, 1, 5, 3}, {3, 4, 5, 6}, {2, 4, 3, 1}});
        //неудачный вариант сложения двух матриц
        Matrix sumMatrix1 = firstMatrix.additionMatrix(secondMatrix);
        sumMatrix1.print();
        //удачный вариант сложения двух матриц (складываем первую матрицу с собой)
        Matrix sumMatrix2 = firstMatrix.additionMatrix(firstMatrix);
        sumMatrix2.print();

        Matrix multiplyNumberMatrix = firstMatrix.multiByNumber(3);
        multiplyNumberMatrix.print();
        //неудачный вариант перемножения двух матриц
        Matrix multiplyMatrix1 = firstMatrix.multiByMatrix(secondMatrix);
        multiplyMatrix1.print();
        //удачный вариант перемножения матриц (умножаем первую матрицу саму на себя)
        Matrix multiplyMatrix2 = firstMatrix.multiByMatrix(firstMatrix);
        multiplyMatrix2.print();
    }
}
