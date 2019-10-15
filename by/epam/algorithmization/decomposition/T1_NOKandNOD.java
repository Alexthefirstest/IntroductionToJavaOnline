/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  1. Написать метод(методы) для нахождения наибольшего общего делителя
 * и наименьшего общего кратного двух натуральных чисел:
 *
 */

package by.epam.algorithmization.decomposition;

public class T1_NOKandNOD {

    public static void main(String[] args) {
        int a = 12;
        int b = 8;

        System.out.println("NOK= " + nok(a, b));
        System.out.println("NOD= " + nod(a, b));
    }


    static public int nok(int a, int b) {
        return (a * b) / nod(a, b);
    }

    static public int nod(int a, int b) {

        int i = Math.min(a, b);
        boolean ok = false;

        while (!ok) {

            if (a % i == 0 && b % i == 0) {
                ok = true;
            }

            i--;
        }
        return i + 1;
    }
}
