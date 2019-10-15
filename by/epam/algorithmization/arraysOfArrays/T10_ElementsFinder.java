/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 10. Найти положительные элементы главной диагонали квадратной матрицы
 *
 */

package by.epam.algorithmization.arraysOfArrays;

public class T10_ElementsFinder {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, -5, 6}, {7, 8, 9}};
        int lenghtx = matrix.length;

        for (int i = 0; i < lenghtx; i++) {

            if (matrix[i][i] > 0) {
                System.out.print(matrix[i][i] + ", ");
            }

        }

    }
}
