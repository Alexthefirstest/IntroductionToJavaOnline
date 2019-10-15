/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  15. Найти все натуральные n-значные числа,
 * цифры в которых образуют строго возрастающую последовательность (например, 1234, 5789).
 * Для решения задачи использовать декомпозицию.
 *
 */

package by.epam.algorithmization.decomposition;

import java.util.Arrays;

public class T15_NubersWithOnlyIncreasingElements {

    public static void main(String[] args) {

        int n = 2;

        System.out.println(Arrays.toString(arrayOfIncreasingNumbersFinder(n)));
    }


    public static int firstNumberWithNElementsFinder(int quantityOfElementsInNumbers) {

        int result = 1;

        while (String.valueOf(result).length() != quantityOfElementsInNumbers) {
            result *= 10;
        }

        return result;
    }


    public static int lastNumberWithNElementsFinder(int quantityOfElementsInNumbers) {

        int result = 9;

        while (String.valueOf(result).length() != quantityOfElementsInNumbers) {
            result = result * 10 + 9;
        }

        return result;
    }

    public static int[] arrayOfNumbersWithNElementsCreator(int quantityOfElementsInNumbers) {

        for (int i = firstNumberWithNElementsFinder(quantityOfElementsInNumbers);
             i <= lastNumberWithNElementsFinder(quantityOfElementsInNumbers); i++) {

            T12_ArrayOfNumbersCreator.arrayCreator(i);

        }

        return T12_ArrayOfNumbersCreator.getAndZeroizeArray();
    }

    public static int[] arrayOfIncreasingNumbersFinder(int quantityOfElementsInNumbers) {

        int[] numbers = arrayOfNumbersWithNElementsCreator(quantityOfElementsInNumbers);

        for (int i = 0; i < numbers.length; i++) {

            if (increasingNumberCheck(numbers[i]) == true) {
                T12_ArrayOfNumbersCreator.arrayCreator(numbers[i]);
            }

        }

        return T12_ArrayOfNumbersCreator.getAndZeroizeArray();
    }


    public static boolean increasingNumberCheck(int number) {

        int[] numberToArray = T10_NumberDevidor.numberToArray(number);

        boolean ok = true;

        int i = 0;

        while (i < numberToArray.length - 1 && ok) {

            if (numberToArray[i] < numberToArray[i + 1]) {
                ok = true;
            } else {
                ok = false;
            }

            i++;
        }

        return ok;
    }

}
