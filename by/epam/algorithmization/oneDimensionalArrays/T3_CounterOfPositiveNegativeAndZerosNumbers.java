/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  3. Дан массив действительных чисел, размерность которого N.
 * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T3_CounterOfPositiveNegativeAndZerosNumbers {

    public static void main(String[] args) {

        double[] numbers = new double[]{-2.4, -2, 5, 10, 15, -6, 15.8, 0};
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        int zeros = 0;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > 0) {
                positiveNumbers++;
            } else if (numbers[i] < 0) {
                negativeNumbers++;
            } else {
                zeros++;
            }

        }

        System.out.println("\n3.\nКоличество положительных чисел: " + positiveNumbers
                + "; Количество отрицательных чисел: "
                + negativeNumbers + "; Количество нулей: " + zeros + ";");
    }
}
