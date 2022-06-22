package ru.sber.oop1.Task3;

public class Matrix {
    int[][] matrix;
    int rows;
    int columns;

    public void setValue(int i, int j, int value) {
        matrix[i][j] = value;
    }

    public int getValue(int row, int columns) {
        return matrix[row][columns];
    }

    public Matrix(int rows, int columns) {
        matrix = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix additionMatrix(Matrix matrix) {
        System.out.println("Матрица, получившаяся после сложения ");
        if (rows != matrix.getRows() || columns != matrix.getColumns()) {
            return new Matrix(0,0);
        }
        Matrix tempArr = new Matrix(rows,columns);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                tempArr.setValue(i,j,this.getValue(i,j) + matrix.getValue(i,j));
            }
        }
        return tempArr;
    }

    public Matrix multiByNumber(int num) {
        System.out.println("Матрица, получившаяся после перемножения на число " + num);
        Matrix tempMatrix = new Matrix(rows, columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                tempMatrix.setValue(i,j,this.getValue(i,j)* num);
            }
        }
        return tempMatrix;
    }

    public Matrix multiByMatrix(Matrix matrix) {
        System.out.println("Матрица, получившаяся после перемножения двух матриц ");
        if (columns != matrix.getColumns() || rows != matrix.getRows()) {
            return new Matrix(0,0);
        }
        Matrix tempArr = new Matrix(rows, matrix.getColumns());
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < matrix.getColumns(); j++) {
                for (int k = 0; k < columns; k++) {
                    tempArr.setValue(i, j, tempArr.getValue(i, j) + this.getValue(i, k) * matrix.getValue(k, j));
                }
            }
        }
        return tempArr;
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
