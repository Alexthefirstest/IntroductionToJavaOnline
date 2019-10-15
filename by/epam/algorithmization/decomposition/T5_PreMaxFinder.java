/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  5. Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но больше всех других элементов).
 *
 */

package by.epam.algorithmization.decomposition;

public class T5_PreMaxFinder {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 2, 3, 4, 5, 5, 9, 7, 8, 9, 9, 9, 8};

        System.out.println(preMaxFinder(numbers));
    }

    public static int maxFinder(int[] numbers) {

        int max = numbers[0];

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }

    public static int preMaxFinder(int[] numbers) {

        int max = maxFinder(numbers);
        int preMax = -999999999;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > preMax && numbers[i] < max) {
                preMax = numbers[i];
            }
        }
        return preMax;
    }

}
