package pl.mj.ai.hopfield;

/**
 * @author Michal.Jedryszka on 12/19/2018
 */
public class Matrix {
    public static double[] metricsVectorMultiplication(double[][] matrix, double[] vector) {
        double[] result = new double[vector.length];
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }

    public static double[][] createMatrix(int numOfRows, int numOfCols) {
        return new double[numOfRows][numOfCols];
    }

    public static double[][] outerProduct(double[] vector) {
        double[][] result = new double[vector.length][vector.length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i][j] = vector[i] * vector[j];
            }
        }
        return result;
    }

    public static double[][] clearDiagonals(double[][] matrix) {
        matrix = copy(matrix);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 0;
        }
        return matrix;
    }

    public static double[][] addMAtrixs(double[][] m1, double[][] m2) {
        double[][] result = new double[m1.length][m1.length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1.length; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return result;
    }

    public static double[][] copy(double[][] matrix){
        double[][] result = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }
}
