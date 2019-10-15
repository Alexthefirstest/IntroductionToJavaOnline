/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  5. Сортировка вставками. Место вставки находить бинарным поиском.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;

public class T5_InsertingSort {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 24, 4, 9, 5, 6, 7, 8, 9, 1, 9, 9, 10, 11};

        int placeToAdd = 0;
        int forSort = 0;
        int forSort2 = 0;

        for (int i = 0; i < array.length; i++) {

            if (i > 0 && array[i] < array[i - 1]) {
                placeToAdd = binarFind(array, i);

                forSort = array[placeToAdd];
                array[placeToAdd] = array[i];

                for (int j = placeToAdd + 1; j <= i; j++) {
                    forSort2 = array[j];
                    array[j] = forSort;
                    forSort = forSort2;
                }

            }

        }

        System.out.println(Arrays.toString(array));
    }


    static int binarFind(int[] array, int numberIndex) {

        int firstIndex = 0;
        int lastIndex = numberIndex - 1;
        int middleIndex = 0;
        int number = array[numberIndex];

        while (firstIndex <= lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;

            if (array[middleIndex] == number) {
                return middleIndex;
            } else if (number > array[middleIndex]) {
                firstIndex = middleIndex + 1;
            } else if (number < array[middleIndex]) {
                lastIndex = middleIndex - 1;
            }


        }//while

        return (array[middleIndex] > array[numberIndex]) ? middleIndex : middleIndex + 1;
    }


}//class
