/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 *
 */

package by.epam.algorithmization.decomposition;

public class T11_MaxLenghtOfNumber {
    public static void main(String[] args) {

        int firsNumber = 14568;
        int secondNumber = 7654138;

        System.out.println(longestNumber(firsNumber, secondNumber));
    }

    public static int longestNumber(int firstNumber, int secondNumber) {

        return (String.valueOf(firstNumber).length() > String.valueOf(secondNumber).length())
                ? firstNumber : secondNumber;
    }
}
