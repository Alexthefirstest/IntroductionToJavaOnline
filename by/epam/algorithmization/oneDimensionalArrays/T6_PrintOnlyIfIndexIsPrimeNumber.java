/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  6. Задана последовательность N вещественных чисел.
 * Вычислить сумму чисел, порядковые номера которых являются простыми числами.
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

class T6_PrintOnlyIfIndexIsPrimeNumber {

    public static void main(String[] args) {

        double[] numbers = new double[]{0, 1, 2, 3, 4.4, 5., 6};
        double sum = 0;

        System.out.print("\n\n6.\nСумма чисел, порядковые номера которых являются проcтыми числами: ");

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 2; j < i - 1; j++) {

                if (i % j == 0) {
                    sum += numbers[i];
                    break;
                }

            }

        }

        System.out.println(sum);
    }
}
