/*
 *
 * 1. Basics of software code development
 *
 *
 * 2. Ветвления
 *
 *2. Найти max{min(a, b), min(c, d)}
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.branchings;

import java.util.Scanner;

public class T2_FindMax {

    public static void main(String[] args) {

        double a;
        double b;
        double c;
        double d;
        double min1;
        double min2;
        double max;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите a: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        a = in.nextDouble();

        System.out.print("Введите b: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        b = in.nextDouble();

        System.out.print("Введите c: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        c = in.nextDouble();

        System.out.print("Введите d: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        d = in.nextDouble();

        min1 = (a < b) ? a : b;
        min2 = (c < d) ? c : d;
        max = (min1 > min2) ? min1 : min2;

        System.out.println("max((min(a,b),(min(c,d))= " + max);
    }
}
