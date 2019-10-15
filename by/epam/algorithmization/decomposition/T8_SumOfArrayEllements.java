/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m.
 *
 */

package by.epam.algorithmization.decomposition;

public class T8_SumOfArrayEllements {

    public static void main(String[] args) {

        int k = 4 - 1;
        int m = 8 - 1;
        int[] numbers = new int[]{1, 2, 10, 20, 300, 400, 5000, 6000};

        System.out.println(sumOf3Elements(numbers, k, m));
    }

    public static int sumOf3Elements(int[] numbers, int startPoint, int finalPoint) {

        startPoint = startElementFinder(startPoint, finalPoint);

        return numbers[startPoint] + numbers[startPoint + 1] + numbers[startPoint + 2];
    }

    public static int startElementFinder(int startPoint, int finalPoint) {

        return (int) (startPoint + (Math.random() * (finalPoint - startPoint - 1)));
    }

}
