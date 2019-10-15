/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  2. Дана последовательность действительных чисел а1 ,а2 ,..., ап.
 * Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T2_ReplacementOnZ {

    public static void main(String[] args) {

        double[] numbers = new double[]{-2.4, -2, 5, 10, 15, -6, 15.8};
        double Z = -3.4;
        int counterOfReplacements = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > Z) {
                numbers[i] = Z;
                counterOfReplacements++;
            }

        }

        System.out.println("\n2.\nПолученная последовательность: " + Arrays.toString(numbers) + ";");
        System.out.println("Количесво произведенных замен: " + counterOfReplacements);

    }
}
