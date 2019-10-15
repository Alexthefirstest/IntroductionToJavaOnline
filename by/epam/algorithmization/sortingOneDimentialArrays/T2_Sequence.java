/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  2. Даны две последовательности: a1 <= a2 <= an и b1 <= b2 <= bm
 * Образовать из них новую последовательность чисел так,
 * чтобы она тоже была неубывающей.
 * Примечание. Дополнительный массив не использовать.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class T2_Sequence {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 44, 55};
        int[] b = new int[]{10, 20, 30, 40, 50, 60};

        a = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();

        Arrays.sort(a);

        System.out.println(Arrays.toString(a));
    }
}
