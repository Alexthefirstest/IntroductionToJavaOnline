/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
 * причем в каждом столбце число единиц равно номеру столбца.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T14_MatrixFormer {

    public static void main(String[] args) {

        int m = 6;
        int n = 4;

        int[][] matrix = new int[m][n];
        int counter = 0;

        for (int j = 0; j < matrix[0].length; j++) {

            while (counter != j + 1) {
                counter = 0;

                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = (int) (Math.random() * 2);

                    if (matrix[i][j] == 1) {
                        counter++;
                    }

                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
