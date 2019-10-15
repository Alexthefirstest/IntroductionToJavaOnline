/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 16. Магические квадраты
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T16_MagicSquare {

    public static void main(String[] args) {

        int n = 3;

        int[][] matrix = new int[n][n];

        int[] numbersOrigin = new int[n * n];

        int sumLine = 0;
        int preSumLine = 0;

        int sumColumn = 0;
        int preSumColumn = 0;

        int sumDiagonal_1 = 0;
        int sumDiagonal_2 = 0;

        boolean magicSquare = false;


        for (int i = 0; i < numbersOrigin.length; i++) {
            numbersOrigin[i] = i + 1;
        }

        int digitsQuantity = n * n;

        int number = 1;
        int timeToStop = 10;

        for (int i = 0; i < digitsQuantity - 1; i++) {
            number = number * 10 + 1;
            timeToStop *= 10;
        }

        int avoidZeros;

        while (number < timeToStop) {

            magicSquare = false;

            avoidZeros = -1;
            boolean sameNumbers = false;

            /*↓задание матрицы*/

            int numberToFillMatrix = number;

            for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < matrix[0].length; j++) {

                    matrix[i][j] = (int) numberToFillMatrix % 10;
                    numberToFillMatrix /= 10;

                    /*есть ли числа равные добавленному перед ним*/
                    for (int q = 0; q <= i; q++) {

                        for (int k = 0; (q == i) ? (k < j) : (k < matrix[0].length); k++) {

                            if (matrix[i][j] == matrix[q][k]) {
                                sameNumbers = true;
                                break;
                            }

                        }

                        if (sameNumbers == true) {
                            break;
                        }

                    }

                    if (sameNumbers == true) {
                        break;
                    }

                    /*избегаем элементы равные 0*/
                    if (matrix[i][j] == 0) {
                        avoidZeros = digitsQuantity - Integer.toString(numberToFillMatrix).length() - 1;
                        break;
                    }

                }

                if (sameNumbers == true) {
                    break;
                }

                if (avoidZeros >= 0) {
                    break;
                }

            }


            if (avoidZeros >= 0) {
                number += Math.pow(10, avoidZeros);
                continue;
            }

            if (sameNumbers == true) {
                number++;
                continue;
            }

            /*↑матрица получена*/


            /*магический квадрат?*/
            sumDiagonal_1 = 0;
            sumDiagonal_2 = 0;

            for (int i = 0; i < n; i++) {
                sumLine = 0;
                sumColumn = 0;
                sumDiagonal_1 += matrix[i][i];
                sumDiagonal_2 += matrix[i][n - 1 - i];

                for (int j = 0; j < n; j++) {
                    sumLine += matrix[i][j];

                    sumColumn += matrix[j][i];
                }

                if (i == 0) {
                    preSumLine = sumLine;
                    preSumColumn = sumColumn;
                }

                if ((preSumLine == sumLine) && (preSumColumn == sumColumn) && (sumColumn == sumLine)) {
                    magicSquare = true;
                } else {
                    magicSquare = false;
                    break;
                }

                preSumLine = sumLine;
                preSumColumn = sumColumn;

            }

            if (magicSquare) {
                magicSquare = ((sumDiagonal_1 == sumLine) && (sumDiagonal_2 == sumLine)) ? true : false;
            }


            if (magicSquare) {
                System.out.println();

                for (int i = 0; i < matrix.length; i++) {
                    System.out.println(Arrays.toString(matrix[i]));
                }

            }

            number++;

        }//while


    }
}
