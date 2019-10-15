/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  8. Дана последовательность целых чисел (a1, a2,... an),
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны
 * min( a1,a2 a3,... ,an )
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T8_ChangeArray {

    public static void main(String[] args) {

        int[] numbers = new int[]{2, 4, 6, 2, 8, 9, 2, 15, 7};
        int min = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] < min) {
                min = numbers[i];
            }

        }

        int counter = 0;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == min) {
                min = numbers[i];
                counter++;
            }

        }

        int[] newNumbers = new int[numbers.length - counter];

        counter = 0;

        for (int i = 0; i < newNumbers.length; i++) {

            if (min == numbers[i + counter]) {
                counter++;
            }

            newNumbers[i] = numbers[i + counter];
        }

        System.out.println("\n8.\nРезультат: " + Arrays.toString(newNumbers));

    }
}
