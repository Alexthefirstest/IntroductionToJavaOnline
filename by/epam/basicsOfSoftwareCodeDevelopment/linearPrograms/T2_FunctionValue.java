/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 * 2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 *z=(b+sqrt(b^2+4*a*c)/2a) - a^3+c+b^(-2)
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T2_FunctionValue {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double a;
        double b;
        double c;
        double q;
        double z;

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

        q = Math.pow((b * b + 4 * a * c), 0.5);
        z = (b + q) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.print("result: " + z);

    }
}
