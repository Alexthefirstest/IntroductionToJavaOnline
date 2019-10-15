/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 *  5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда,
 * модуль которых больше или равен заданному е. Общий член ряда имеет вид:
 *a(n)=1/2^n+1/3^n
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.util.Scanner;

public class T5_SumOfNumbersRange {

    public static void main(String[] args) {

        double e;
        double n;
        double summ = 0;
        double member = 1;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите n: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        n = in.nextDouble();

        System.out.print("Введите e: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        e = in.nextDouble();

        if (e == 0.) {
            summ = ((double) 1 / (double) Math.pow(2, n)) / (1 - (double) 1 / 2)
                    + ((double) 1 / (double) Math.pow(3, n)) / (1 - (double) 1 / 3);
        } else {

            while (Math.abs(member) >= e) {
                member = (1 / Math.pow(2, n) + 1 / Math.pow(3, n));
                summ = Math.abs(member) >= e ? summ + member : summ;
                n++;
            }

        }

        System.out.println("Result: " + summ);
    }
}
