/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  6.Сортировка Шелла.
 * Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1
 * Если ai < ai+1 то продвигаются на один элемент вперед. Если ai > ai+1
 * то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;

public class T6_ShellSort {

    public static void main(String[] args) {

        int[] array = new int[]{100, 2, 24, 3, 4, 9, 17, 9, 1, 9, 9, 10, 0};
        int forSort;

        int i = 0;

        while (i < array.length - 1) {

            if (array[i] > array[i + 1]) {
                forSort = array[i];
                array[i] = array[i + 1];
                array[i + 1] = forSort;
                i--;
            } else {
                i++;
            }

            if (i < 0) {
                i = 0;
            }

        }
        System.out.println(Arrays.toString(array));

    }
}