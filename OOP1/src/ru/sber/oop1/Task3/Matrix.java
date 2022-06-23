package ru.sber.oop1.Task3;

public class Matrix {
    int[][] matrix;
    int rows;
    int columns;

    Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    Matrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getValue(int row, int columns) {
        return matrix[row][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix additionMatrix(Matrix matrix) {
        if (rows != matrix.getRows() || columns != matrix.getColumns()) {
            System.out.println("Сложение невозможно, матрицы разной размерности!");
            return new Matrix(0,0);
        }
        System.out.println("Матрица, получившаяся после сложения ");
        Matrix tempMatrix = new Matrix(rows,columns);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                tempMatrix.setValue(i,j,this.getValue(i,j) + matrix.getValue(i,j));
            }
        }
        return tempMatrix;
    }

    public Matrix multiByNumber(int num) {
        System.out.println("Матрица, получившаяся после перемножения на число " + num);
        Matrix tempMatrix = new Matrix(rows, columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                tempMatrix.setValue(i,j,this.getValue(i,j) * num);
            }
        }
        return tempMatrix;
    }

    public Matrix multiByMatrix(Matrix matrix) {
        if (columns != matrix.getRows()) {
            System.out.println("Число столбцов первой матрицы != числу строк второй матрицы! Перемножение невозможно");
            return new Matrix(0,0);
        }
        System.out.println("Матрица, получившаяся после перемножения двух матриц ");
        Matrix tempMatrix = new Matrix(matrix.getRows(), matrix.getColumns());
        for (int i = 0; i < matrix.getRows(); i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < matrix.getRows(); k++) {
                    tempMatrix.setValue(i, j, tempMatrix.getValue(i, j) + this.getValue(i, k) * matrix.getValue(k, j));
                }
            }
        }
        return tempMatrix;
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.getValue(i,j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
