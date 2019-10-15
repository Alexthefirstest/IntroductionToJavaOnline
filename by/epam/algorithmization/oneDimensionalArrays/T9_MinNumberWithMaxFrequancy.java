/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 * Если таких чисел несколько, то определить наименьшее из них.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T9_MinNumberWithMaxFrequancy {

    public static void main(String[] args) {

        int[] numbers = new int[]{3, 3, 3, 4, 8, 4, 4, 4, 9, 5, 5, 5, 5};
        int[] frequancy = new int[numbers.length];

        int max = -1;
        int maxi = 0;
        int number;
        int realCounter = 0;

        Arrays.sort(numbers);
        System.out.print("\n9.\nРезультат: ");

        for (int i = 0; i < numbers.length; ) {

            number = numbers[i];

            while (i < numbers.length && number == numbers[i]) {
                frequancy[realCounter]++;
                i++;
            }

            if (max < frequancy[realCounter]) {
                max = frequancy[realCounter];
                maxi = i - 1;
            }

            realCounter++;

        }

        System.out.println(numbers[maxi]);

    }
}
