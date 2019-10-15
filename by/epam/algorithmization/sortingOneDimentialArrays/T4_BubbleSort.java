/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  4. Сортировка обменами
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;

public class T4_BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10, 11};
        int forSort;
        int replacement = 0;

        for (int i = array.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (array[j] < array[j + 1]) {
                    forSort = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = forSort;
                    replacement++;
                }

            }

        }

        System.out.println(Arrays.toString(array));
        System.out.println(replacement);

    }
}
