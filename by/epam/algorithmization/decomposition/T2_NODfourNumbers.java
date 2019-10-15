/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел
 *
 */

package by.epam.algorithmization.decomposition;

public class T2_NODfourNumbers {

    public static void main(String[] args) {

        int a = 12;
        int b = 8;
        int c = 4;
        int d = 32;

        System.out.println("NOD= " + nod(a, b, c, d));
    }

    static public int nod(int a, int b, int c, int d) {

        int i = Math.min(Math.min(a, b), Math.min(c, d));
        boolean ok = false;

        while (!ok) {

            if ((a % i == 0) && (b % i == 0) && (c % i == 0) && (d % i == 0)) {
                ok = true;
            }

            i--;
        }

        return i + 1;
    }
}
