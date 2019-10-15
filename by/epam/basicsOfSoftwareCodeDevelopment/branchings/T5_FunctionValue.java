/*
 *
 * 1. Basics of software code development
 *
 *
 * 2. Ветвления
 *
 *5. Вычислить значение функции:
 * F(x)=
 * x^2-3x+9, if x<=3
 * 1/(x^3+6), if x>3
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.branchings;

import java.util.Scanner;

public class T5_FunctionValue {

    public static void main(String[] args) {

        double x;
        double y;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите x: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        x = in.nextDouble();

        if (x <= 3) {
            y = x * x - 3 * x + 9;
        } else {
            y = 1 / (x * x * x + 6);
        }

        System.out.print("F(x)= " + y);
    }
}