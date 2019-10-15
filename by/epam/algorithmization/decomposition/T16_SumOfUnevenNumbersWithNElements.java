/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме.
 *  Для решения задачи использовать декомпозицию.
 *
 */

package by.epam.algorithmization.decomposition;

public class T16_SumOfUnevenNumbersWithNElements {

    public static void main(String[] args) {

        int n = 2;
        int sumOfUnevenNumbersWithNElements = sumOfNumbers(NumbersWithOnlyUnevenElementsFinder(n));

        System.out.println(sumOfUnevenNumbersWithNElements);
        System.out.println(quantityOfEvenElementsInNumber(sumOfUnevenNumbersWithNElements));
    }

    public static int[] NumbersWithOnlyUnevenElementsFinder(int quantityOfNElementsInNumbers) {

        int[] numbers =
                T15_NubersWithOnlyIncreasingElements.arrayOfNumbersWithNElementsCreator(quantityOfNElementsInNumbers);

        for (int i = 0; i < numbers.length; i++) {

            if (isConsistOnlyUnevenElementsInNumber(numbers[i]) == true) {
                T12_ArrayOfNumbersCreator.arrayCreator(numbers[i]);
            }

        }
        return T12_ArrayOfNumbersCreator.getAndZeroizeArray();
    }

    public static boolean isConsistOnlyUnevenElementsInNumber(int number) {

        int[] numberIntoArray = T10_NumberDevidor.numberToArray(number);
        boolean ok = true;
        int i = 0;

        while (i < numberIntoArray.length && ok) {

            if (numberIntoArray[i] % 2 != 0) {
                ok = true;
            } else {
                ok = false;
            }
            i++;

        }
        return ok;
    }

    public static int quantityOfEvenElementsInNumber(int number) {

        int[] numberIntoArray = T10_NumberDevidor.numberToArray(number);
        int counter = 0;

        for (int i = 0; i < numberIntoArray.length; i++) {

            if (numberIntoArray[i] % 2 == 0) {
                counter++;
            }

        }
        return counter;
    }

    public static int sumOfNumbers(int numbers[]) {

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

}
