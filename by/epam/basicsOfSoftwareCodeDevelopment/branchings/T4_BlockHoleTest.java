/*
 *
 * 1. Basics of software code development
 *
 *
 * 2. Ветвления
 *
 *4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
 * Определить, пройдет ли кирпич через отверстие.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.branchings;

import java.util.Scanner;

public class T4_BlockHoleTest {

    public static void main(String[] args) {

        int x;
        int y;
        int z;

        int A;
        int B;

        int maxHoleSide;
        int minHoleSide;
        int minBlockSide1;
        int minBlockSide2;
        int maxBlockSideof2;
        int minBlockSIde;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите размер стороны x кирпича: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        x = in.nextInt();
        System.out.print("Введите размер стороны y кирпича: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        y = in.nextInt();

        System.out.print("Введите размер стороны z кирпича: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        z = in.nextInt();

        System.out.print("Введите размер стороны A отверстия: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        A = in.nextInt();
        System.out.print("Введите размер стороны B отверстия: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        B = in.nextInt();

        maxHoleSide = (A > B) ? A : B;
        minHoleSide = (A < B) ? A : B;

        if (x < y) {
            minBlockSide1 = x;
        } else {
            minBlockSide1 = y;
        }

        if (minBlockSide1 == x) {
            minBlockSide2 = (y < z) ? y : z;
        } else {
            minBlockSide2 = (x < z) ? x : z;
        }

        maxBlockSideof2 = (minBlockSide1 > minBlockSide2) ? minBlockSide1 : minBlockSide2;
        minBlockSIde = (minBlockSide1 < minBlockSide2) ? minBlockSide1 : minBlockSide2;

        if ((maxHoleSide >= maxBlockSideof2) && (minHoleSide >= minBlockSIde)) {
            System.out.println("кирпич пройдет через отверстие");
        } else {
            System.out.println("кирпич не пройдет через отверстие");
        }

    }
}
