/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  10. Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.
 *
 */

package by.epam.algorithmization.decomposition;

public class T10_NumberDevidor {

    public static void main(String[] args) {

        int number = 46849;

        System.out.println(java.util.Arrays.toString(numberToArray(number)));
    }

    public static int getiingLastNumberSElement(int number) {
        return number % 10;
    }

    public static int[] numberToArray(int number) {

        int numberLength = String.valueOf(number).length();
        int[] balances = new int[numberLength];

        for (int i = 0; i < numberLength; i++) {
            balances[numberLength - 1 - i] = getiingLastNumberSElement(number);
            number /= 10;
        }

        return balances;
    }
}
