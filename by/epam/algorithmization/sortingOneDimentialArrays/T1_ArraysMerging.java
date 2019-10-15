/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами первого,
 * при этом не используя дополнительный массив.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.*;
import java.util.stream.IntStream;

public class T1_ArraysMerging {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{10, 20, 30, 40, 50, 60};
        int k = 2;

        int aLenght = a.length;

        a = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();

        System.arraycopy(a, k, a, a.length - (aLenght - k), aLenght - k);
        System.arraycopy(b, 0, a, k, b.length);

        System.out.println(Arrays.toString(a));
    }
}
