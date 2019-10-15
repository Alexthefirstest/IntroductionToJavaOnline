/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T13_MatrixColumnSorter {

    public static void main(String[] args) {

        /*по возрастанию*/
        int[][] matrix = new int[][]{{1, 5, 5, 5}, {0, 1, 1, 1}, {3, 8, 8, 7}, {4, 0, 0, 8}};
        int forCopy;

        for (int i = matrix[0].length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                int k = 0;

                while (matrix[k][j] == matrix[k][j + 1] && k < matrix.length - 1) {
                    k++;
                }

                if (matrix[k][j] > matrix[k][j + 1]) {

                    for (int z = 0; z < matrix.length; z++) {
                        forCopy = matrix[z][j];
                        matrix[z][j] = matrix[z][j + 1];
                        matrix[z][j + 1] = forCopy;
                    }
                }

            }
        }

        System.out.println("\nпо возрастанию");

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        /*по убыванию*/
        int[][] matrix2 = new int[][]{{1, 5, 5, 5}, {0, 1, 1, 1}, {3, 7, 8, 8}, {4, 8, 0, 0}};
        int forCopy2;

        for (int i = matrix2[0].length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                int k = 0;

                while (matrix2[k][j] == matrix2[k][j + 1] && k < matrix2.length - 1) {
                    k++;
                }

                if (matrix2[k][j] < matrix2[k][j + 1]) {

                    for (int z = 0; z < matrix2.length; z++) {
                        forCopy2 = matrix2[z][j];
                        matrix2[z][j] = matrix2[z][j + 1];
                        matrix2[z][j + 1] = forCopy2;
                    }
                }

            }
        }

        System.out.println("\nпо убыванию");

        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }

    }
}
