/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенных в степень n, равна самому числу. Найти все числа Армстронга от 1 до k.
 * Для решения задачи использовать декомпозицию.
 *
 */

package by.epam.algorithmization.decomposition;

import java.util.Arrays;

public class T14_ArmstrongsNumbers {

    public static void main(String[] args) {

        int k = 500;

        System.out.println(Arrays.toString(resultCreator(k)));
    }

    public static int[] resultCreator(int finalPoint) {

        for (int i = 1; i <= finalPoint; i++) {

            if (isArmstrongCheck(i) == true) {
                T12_ArrayOfNumbersCreator.arrayCreator(i);
            }

        }
        return T12_ArrayOfNumbersCreator.getArray();
    }

    public static boolean isArmstrongCheck(int number) {

        int[] numberToArray = T10_NumberDevidor.numberToArray(number);
        int summ = 0;

        for (int i = 0; i < numberToArray.length; i++) {
            summ += Math.pow(numberToArray[i], numberToArray.length);
        }

        return (summ == number) ? true : false;
    }
}
