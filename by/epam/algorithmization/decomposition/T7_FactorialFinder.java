/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 *
 */

package by.epam.algorithmization.decomposition;

public class T7_FactorialFinder {

    public static void main(String[] args) {

        int leftBorder = 1;
        int rightBorder = 9;

        System.out.println(factoralOfUnevenNumbers(leftBorder, rightBorder));
    }

    public static int factorial(int number) {
        int result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    public static int factoralOfUnevenNumbers(int leftBorder, int rightBorder) {

        int i = leftBorder % 2 != 0 ? leftBorder : leftBorder + 1;
        int result = 0;

        for (; i <= rightBorder; i += 2) {
            result += factorial(i);
        }

        return result;
    }

}
