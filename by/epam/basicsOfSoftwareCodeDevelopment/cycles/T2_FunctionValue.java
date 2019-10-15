/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 *  2.Вычислить значения функции на отрезке [а,b] c шагом h:
 *  x, if x>2
 * -x, if<=2
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.util.Scanner;

public class T2_FunctionValue {

    public static void main(String[] args) {

        double a = 1;
        double b = 7;
        double h;
        double x;
        double y;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите координату начало отрезка: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        a = in.nextDouble();

        System.out.print("Введите координату конца отрезка: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        b = in.nextDouble();
        System.out.print("Введите шаг: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        h = in.nextDouble();

        x = a;

        do {
            y = (x > 2) ? x : -x;
            System.out.println("F(" + x + ") = " + y);
            x = x + h;

        } while (x <= b);

    }
}
