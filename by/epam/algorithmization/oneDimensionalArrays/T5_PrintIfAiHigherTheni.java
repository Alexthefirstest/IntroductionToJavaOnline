/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

class T5_PrintIfAiHigherTheni {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 3, 20, 10, -4, 4};
        boolean atLeasOneResuln = false;

        System.out.print("\n5.\nЧисла, для которых верно выражение a[i]>i: "); //i Начинается с 1

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > i + 1) {
                System.out.print(numbers[i] + ", ");
                atLeasOneResuln = true;
            }

        }

        System.out.print("\b\b;");

        if (atLeasOneResuln == false) {
            System.out.print("\b, не найдеы");
        }

    }
}
