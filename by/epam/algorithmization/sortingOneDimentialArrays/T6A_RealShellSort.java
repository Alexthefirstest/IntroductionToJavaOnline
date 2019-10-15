/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  6.Сортировка Шелла.
 *  Инструкция предоставлена интернетом.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;

public class T6A_RealShellSort {

    public static void main(String[] args) {

        int[] array = new int[]{20, 2, 24, 3, 4, 9, 17, 9, 1, 9, 9, 10, 0};
        int gap = array.length / 2;
        int forSort;

        while (gap >= 1) {

            for (int right = 0; right < array.length; right++) {

                for (int c = right - gap; c >= 0; c -= gap) {

                    if (array[c] > array[c + gap]) {
                        forSort = array[c];
                        array[c] = array[c + gap];
                        array[c + gap] = forSort;
                    }

                }

            }

            gap = gap / 2;
        }
        System.out.println(Arrays.toString(array));
    }
}