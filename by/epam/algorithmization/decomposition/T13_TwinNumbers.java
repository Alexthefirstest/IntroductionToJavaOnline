/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 *
 */

package by.epam.algorithmization.decomposition;

public class T13_TwinNumbers {

    public static void main(String[] args) {

        int n = 4;

        printResult(n);
    }

    public static int[] resultCreator(int statrPoint) {

        for (int i = statrPoint; i < 2 * statrPoint - 1; i++) {
            T12_ArrayOfNumbersCreator.arrayCreator(i);
            T12_ArrayOfNumbersCreator.arrayCreator(i + 2);
        }

        return T12_ArrayOfNumbersCreator.getArray();

    }

    public static void printResult(int startPoint) {

        int[] result = resultCreator(startPoint);

        for (int i = 0; i < result.length - 1; i += 2) {
            System.out.println((result[i]) + " " + result[i + 1]);
        }

    }
}
