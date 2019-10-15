/*
 *
 *  2. Algorithmization
 *
 *
 *  1. одномерные массивы
 *
 *  7. суммировать первое и последнее, второе и предпоследнее и т.д. - найти максимальную сумму
 *
 */

package by.epam.algorithmization.oneDimensionalArrays;

class T7_MaximumOfArrayElements {

    public static void main(String[] args) {

        double[] numbers = new double[]{0, 1, 2, 4.4, 5., 20, 8, 4};
        double max = numbers[0] + numbers[numbers.length - 1];

        for (int i = 1; i < numbers.length / 2; i++) {
            max = (numbers[i] + numbers[numbers.length - i - 1]) > max ?
                    (numbers[i] + numbers[numbers.length - i - 1]) : max;
        }

        System.out.println("\n7.\nРезультат: " + max);
    }
}
