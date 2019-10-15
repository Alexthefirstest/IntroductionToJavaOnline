/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  3. Сортировка выбором
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;

public class T3_SortingByChoise {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10, 11};
        int min;
        int minI;
        int forSort;

        for (int i = 0; i < array.length; i++) {
            min = array[i];
            minI = i;

            for (int j = i + 1; j < array.length; j++) {

                if (min < array[j]) {
                    min = array[j];
                    minI = j;
                }

            }

            if (i != minI) {
                forSort = array[i];
                array[i] = array[minI];
                array[minI] = forSort;
            }

        }

        System.out.println(Arrays.toString(array));
    }
}
