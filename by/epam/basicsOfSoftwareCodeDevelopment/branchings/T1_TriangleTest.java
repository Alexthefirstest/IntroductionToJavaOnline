/*
 *
 * 1. Basics of software code development
 *
 *
 * 2. Ветвления
 *
 *1. Даны два угла треугольника (в градусах).
 * Определить, существует ли такой треугольник, и если да, то будет ли он прямоугольным.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.branchings;

import java.util.Scanner;

public class T1_TriangleTest {

    public static void main(String[] args) {

        double angle1;
        double angle2;
        double angle3;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите значения первого угла трегольника: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        angle1 = in.nextDouble();

        System.out.print("Введите второго угла треугольника: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        angle2 = in.nextDouble();
        angle3 = 180 - angle1 - angle2;

        if ((angle1 > 0) && (angle2 > 0) && (angle3 > 0)) {
            System.out.print("треугольник существует");

            if ((angle1 == 90) || (angle2 == 90) || (angle3 == 90)) {
                System.out.print(" - прямоугольный");
            } else {
                System.out.print(" - не прямоугольный");
            }
        } else {
            System.out.print("треугольник не существует");
        }

    }
}
