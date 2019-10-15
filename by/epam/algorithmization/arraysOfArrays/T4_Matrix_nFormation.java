/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  4. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 *  1  2  3  ... n
 * n n-1 n-2 ... n
 *...
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T4_Matrix_nFormation {

    public static void main(String[] args) {

        int n = 4;
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i += 2) {

            for (int j = 0; j < n; j++) {
                matrix[i][j] = j + 1;
                matrix[i + 1][j] = n - j;
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
