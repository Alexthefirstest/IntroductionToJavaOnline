/*
 *
 * 1. Basics of software code development
 *
 *
 * 2. Ветвления
 *
 *3.  Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.branchings;

import java.util.Scanner;

public class T3_LineTest {

    public static void main(String[] args) {

        int[] A = new int[2];
        int[] B = new int[2];
        int[] C = new int[2];
        Scanner in = new Scanner(System.in);
        int area;

        System.out.print("Введите A(x): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        A[0] = in.nextInt();

        System.out.print("Введите A(y): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        A[1] = in.nextInt();

        System.out.print("Введите B(x): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        B[0] = in.nextInt();

        System.out.print("Введите B(y): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        B[1] = in.nextInt();

        System.out.print("Введите C(x): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        C[0] = in.nextInt();

        System.out.print("Введите C(y): ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        C[1] = in.nextInt();

        area = (A[0] - C[0]) * (B[1] - C[1]) - (B[0] - C[0]) * (A[1] - C[1]);

        if (area == 0) {
            System.out.print("точки лежат на одной прямой");
        } else {
            System.out.print("точки не лежат на одной прямой");
        }

    }
}
