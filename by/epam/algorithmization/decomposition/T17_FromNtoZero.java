/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
 * Сколько таких действий надо произвести, чтобы получился нуль?
 * Для решения задачи использовать декомпозицию
 *
 */

package by.epam.algorithmization.decomposition;

public class T17_FromNtoZero {

    public static void main(String[] args) {

        int n = 23;

        System.out.println(result(n));
    }

    public static int result(int number) {

        int counter = 0;

        while (number > 0) {
            int[] numberIntoArray = T10_NumberDevidor.numberToArray(number);
            int summ = T16_SumOfUnevenNumbersWithNElements.sumOfNumbers(numberIntoArray);

            number -= summ;

            counter++;
        }

        return counter;
    }

}
