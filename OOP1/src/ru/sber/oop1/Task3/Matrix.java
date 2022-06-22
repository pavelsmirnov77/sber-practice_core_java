package ru.sber.oop1.Task3;

public class Matrix {
    int[][] array;
    int rows;
    int columns;

    public void setValue(int i, int j, int value) {
        array[i][j] = value;
    }

    public int getValue(int row, int columns) {
        return array[row][columns];
    }

    public Matrix(int rows, int columns) {
        array = new int[rows][columns];
        this.rows = rows;
        this.columns = columns;
    }

    public Matrix(int[][] array) {
        this.array = array;
        rows = array.length;
        columns = array[0].length;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix additionMatrix(Matrix arr) {
        System.out.println("Получившаяся матрица после сложения ");
        if (rows != arr.getRows() || columns != arr.getColumns()) {
            return new Matrix(0,0);
        }
        Matrix tempArr = new Matrix(rows,columns);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < columns; j++) {
                tempArr.setValue(i,j,this.getValue(i,j) + arr.getValue(i,j));
            }
        }
        return tempArr;
    }

    public Matrix multiByNumber(int num) {
        System.out.println("Получившаяся матрица после перемножения на число " + num);
        Matrix tempMatrix = new Matrix(rows, columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                tempMatrix.setValue(i,j,this.getValue(i,j)* num);
            }
        }
        return tempMatrix;
    }

    public Matrix multiByMatrix(Matrix arr) {
        System.out.println("Матрица, получившаяся после перемножения двух матриц ");
        if (columns != arr.getColumns() || rows != arr.getRows()) {
            return new Matrix(0,0);
        }
        Matrix tempArr = new Matrix(rows, arr.getColumns());
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < arr.getColumns(); j++) {
                for (int k = 0; k < columns; k++) {
                    tempArr.setValue(i, j, tempArr.getValue(i, j) + this.getValue(i, k) * arr.getValue(k, j));
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
