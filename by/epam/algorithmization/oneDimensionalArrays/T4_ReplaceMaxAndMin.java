/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T4_ReplaceMaxAndMin {

    public static void main(String[] args) {

        double[] numbers = new double[]{-2.4, -2, 5, 10, 15, -6, 15.8, 0};
        double max = numbers[0] - 1;
        int indexMax = 0;
        double min = numbers[0] + 1;
        int indexMin = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > max) {
                max = numbers[i];
                indexMax = i;
            }

            if (numbers[i] < min) {
                min = numbers[i];
                indexMin = i;
            }

        }

        numbers[indexMax] = min;
        numbers[indexMin] = max;
        System.out.println("\n4.\nПолученная последовательность: " + Arrays.toString(numbers) + ";");

    }
}
