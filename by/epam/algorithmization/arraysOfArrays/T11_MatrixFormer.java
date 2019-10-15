/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 11. Матрицу 10x20 заполнить случайными числами от 0 до 15.
 * Вывести на экран саму матрицу и номера строк,
 * в которых число 5 встречается три и более раз
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T11_MatrixFormer {

    public static void main(String[] args) {

        int[][] matrix = new int[10][20];
        int[] fivesCounter = new int[10];

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 20; j++) {
                matrix[i][j] = (int) (Math.random() * 16);

                if (matrix[i][j] == 5)
                    fivesCounter[i]++;
            }

        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        System.out.print("Строки, в которых число 5 встречается три и более раз: ");

        for (int i = 0; i < 10; i++) {

            if (fivesCounter[i] >= 3) {
                System.out.print((i + 1) + ", ");
            }

        }

    }
}
