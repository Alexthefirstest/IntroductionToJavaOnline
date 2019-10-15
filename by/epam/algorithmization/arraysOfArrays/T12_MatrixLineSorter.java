/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T12_MatrixLineSorter {

    public static void main(String[] args) {

        /*по возрастанию*/
        int[][] matrix = new int[][]{{1, 2, 7, 40}, {10, 5, 6, 70}, {10, 4, 9, 102},
                                     {1, 2, 5, 140}, {1000, 2000, 3000, 4000},
                                     {1000, 3000, 3000, 4000}, {10, 4, 9, 101}};
        int[] lineCopy;

        for (int i = matrix.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                int k = 0;

                while (matrix[j][k] == matrix[j + 1][k] && k < matrix[0].length - 1) {
                    k++;
                }

                if (matrix[j][k] > matrix[j + 1][k]) {
                    lineCopy = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = lineCopy;
                }

            }
        }

        System.out.println("\nпо возрастанию");

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        /*по убыванию*/
        int[][] matrix1 = new int[][]{{1, 2, 7, 40}, {10, 5, 6, 70}, {10, 4, 9, 100},
                                      {1, 2, 5, 140}, {1000, 2000, 3000, 4000},
                                      {1000, 3000, 3000, 4000}, {10, 4, 9, 100}};
        int[] lineCopy1;


        for (int i = matrix1.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                int k = 0;

                while (matrix1[j][k] == matrix1[j + 1][k] && k < matrix1[0].length - 1) {
                    k++;
                }

                if (matrix1[j][k] < matrix1[j + 1][k]) {
                    lineCopy1 = matrix1[j];
                    matrix1[j] = matrix1[j + 1];
                    matrix1[j + 1] = lineCopy1;
                }

            }
        }
        System.out.println("\nпо убыванию");

        for (int i = 0; i < matrix1.length; i++) {
            System.out.println(Arrays.toString(matrix1[i]));
        }

    }
}
