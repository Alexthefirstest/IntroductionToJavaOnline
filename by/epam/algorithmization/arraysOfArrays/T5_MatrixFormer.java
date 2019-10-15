/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * 1 1 1 1 1 1
 * 2 2 2 2 2 0
 * 3 3 3 3 0 0
 *...
 * 6 0 0 0 0 0
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T5_MatrixFormer {

    public static void main(String[] args) {

        int n = 4;
        int[][] matrix = new int[n][n];
        int lenght = n;

        for (int i = 0; i < lenght; i++) {

            for (int j = 0; j < n; j++) {
                matrix[i][j] = i + 1;
            }

            n -= 1;

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
