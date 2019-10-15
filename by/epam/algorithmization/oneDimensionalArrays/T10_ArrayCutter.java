/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  10. Дан целочисленный массив с количеством элементов п.
 * Сжать массив, выбросив из него каждый второй элемент (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

import java.util.Arrays;

class T10_ArrayCutter {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int lenght = (numbers.length % 2 == 0)
                     ? (numbers.length / 2) : (numbers.length / 2 + 1);

        int i = 1;

        for (; i < lenght; i++) {
            numbers[i] = numbers[i + i];
        }

        for (; i < numbers.length; i++) {
            numbers[i] = 0;
        }

        System.out.print("\n10.\nРезультат: ");
        System.out.print(Arrays.toString(numbers));
    }
}
