/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 *
 */

package by.epam.algorithmization.decomposition;

import java.util.Arrays;
import java.util.stream.IntStream;

public class T12_ArrayOfNumbersCreator {

    private static int[] array = new int[0];

    public static void main(String[] args) {

        int k = 4;
        int n = 50;

        System.out.println(Arrays.toString(resultCreator(k, n)));
    }

    public static int[] getAndZeroizeArray() {

        int[] array1 = array;
        array = new int[0];
        return array1;
    }

    public static int[] resultCreator(int mustSumm, int maxNumber) {

        for (int i = 0; i <= maxNumber; i++) {

            int sumOfElements = numberElementsSumm(i);

            if (sumOfElements == mustSumm) {
                arrayCreator(i);
            }

        }
        return array;
    }

    public static void arrayCreator(int number) {

        int[] numberArray = new int[]{number};

        array = IntStream.concat(Arrays.stream(array), Arrays.stream(numberArray)).toArray();
    }

    public static int numberElementsSumm(int number) {

        int[] numberIntoArray;
        numberIntoArray = T10_NumberDevidor.numberToArray(number);
        int sum = 0;

        for (int i = 0; i < numberIntoArray.length; i++) {
            sum += numberIntoArray[i];
        }

        return sum;
    }


    /*для других классов*/
    public static void ziroizeArray() {
        array = new int[0];
    }

    public static int[] getArray() {
        return array;
    }
}
