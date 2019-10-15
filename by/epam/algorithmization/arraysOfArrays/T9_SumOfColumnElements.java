/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
 * Определить, какой столбец содержит максимальную сумму.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

public class T9_SumOfColumnElements {

    public static void main(String[] args) {


        int[][] matrix = new int[][]{{1, 2, 3, 6}, {4, 5, 6, 3}, {7, 8, 9, 9}};

        int sumOfElements[] = new int[matrix[0].length];
        int maximumSum = -1;

        for (int j = 0; j < matrix[0].length; j++) {

            for (int i = 0; i < matrix.length; i++) {
                sumOfElements[j] += matrix[i][j];
            }

            maximumSum = sumOfElements[j] > maximumSum ? sumOfElements[j] : maximumSum;
            System.out.println((j + 1) + "cl, sum: " + sumOfElements[j]);
        }

        System.out.println("\nMaxSum: " + maximumSum);
        System.out.print("Столбцы с максимальной суммой элементов ");

        for (int j = 0; j < matrix[0].length; j++) {

            if (maximumSum == sumOfElements[j]) {
                System.out.print((j + 1) + ", ");
            }

        }

    }
}
