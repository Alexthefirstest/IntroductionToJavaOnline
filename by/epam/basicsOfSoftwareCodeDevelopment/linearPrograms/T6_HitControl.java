/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 *6. Для данной области составить линейную программу,
 * которая печатает true, если точка с координатами (х, у) принадлежит закрашенной области,
 *  и false — в противном случае
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T6_HitControl {

    public static void main(String[] args) {

        int[] point = new int[2];
        int xABS;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите x: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        point[0] = in.nextInt();

        System.out.print("Введите y: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        point[1] = in.nextInt();

        xABS = Math.abs(point[0]);

        if (xABS <= 2 && (point[1] >= 0 && point[1] <= 4)) {
            System.out.print("true");
        } else if (xABS <= 4 && (point[1] >= -3 && point[1] <= 0)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }

    }
}
