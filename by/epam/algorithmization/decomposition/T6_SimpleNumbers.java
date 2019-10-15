/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 *
 */

package by.epam.algorithmization.decomposition;

public class T6_SimpleNumbers {

    public static void main(String[] args) {

        int[] numbers = new int[]{9, 6, 3};

        System.out.println(numbersSimplTest(numbers));
    }

    public static boolean numbersSimplTest(int[] numbers) {

        boolean simple = true;
        int i = 0;
        int j;

        while (simple && i < numbers.length - 1) {
            j = i + 1;

            while (simple && j < numbers.length) {

                if (T1_NOKandNOD.nod(numbers[i], numbers[j]) == 1) { //вызов метода для нахождения НОД из задачи 1
                    simple = false;
                }

                j++;

            }

            i++;
        }
        return simple;
    }

}

