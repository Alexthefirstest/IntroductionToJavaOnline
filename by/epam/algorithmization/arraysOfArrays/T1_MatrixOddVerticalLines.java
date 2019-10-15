/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

public class T1_MatrixOddVerticalLines {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 30, 80}, {10, 5, 11, 9}, {9, 7, 8, 15}};

        for (int j = 0; j < matrix[0].length; j += 2) {

            if (matrix[0][j] > matrix[matrix.length - 1][j]) {

                System.out.println("Столбец " + (j + 1) + ": ");

                for (int i = 0; i < matrix.length; i++) {
                    System.out.println(matrix[i][j]);
                }

            }

        }

    }
}
