/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

public class T1_SumOfNumbersMultiplyK {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 6, 3, 9};
        int sum = 0;
        int K = 3;

        System.out.print("1.\nCумма чисел, кратных " + K + ": ");

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] % K == 0) {
                sum += numbers[i];
            }

        }

        System.out.println(sum);
    }
}

