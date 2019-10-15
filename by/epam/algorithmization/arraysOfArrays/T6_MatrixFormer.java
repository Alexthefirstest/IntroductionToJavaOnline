/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  6. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 1 1 1 1 1
 * 0 1 1 1 1 0
 * 0 0 1 1 0 0
 *...
 * 0 1 1 1 1 0
 * 1 1 1 1 1 1
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T6_MatrixFormer {

    public static void main(String[] args) {

        int n = 6;

        int[][] matrix = new int[n][n];
        int lenght = n / 2;

        for (int i = 0; i < lenght; i++) {

            for (int j = i; j < n - i; j++) {
                matrix[i][j] = 1;

                matrix[n - i - 1][j] = 1;
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
