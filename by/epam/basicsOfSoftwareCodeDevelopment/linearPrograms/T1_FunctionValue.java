/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 * 1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T1_FunctionValue {

    public static void main(String[] args) {

        double z = 0;
        double a = 0;
        double b = 0;
        double c = 0;
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

        z = ((a - 1) * b / 2) + c;
        System.out.println("z= " + z);
    }
}
