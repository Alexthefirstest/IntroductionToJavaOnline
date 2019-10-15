/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 7. Сформировать квадратную матрицу порядка N по правилу:
 * a[i,j]=sin ((i^2-j^2)/n)
 *
 * и подсчитать количество положительных элементов в ней.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T7_MatrixFormer {

    public static void main(String[] args) {

        int positiveNumbersCounter = 0;
        int n = 4;

        double[][] matrix = new double[n][n];
        double forsin;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                forsin = (double) ((Math.pow(i + 1, 2) - Math.pow(j + 1, 2)) / n);
                matrix[i][j] = Math.sin(forsin);

                if (matrix[i][j] > 0) {
                    positiveNumbersCounter++;
                }

            }

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.println("\n Количество положительных элементов в матрице: " + positiveNumbersCounter);
    }
}
