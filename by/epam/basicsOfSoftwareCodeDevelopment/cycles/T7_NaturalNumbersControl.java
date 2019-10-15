/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 * 7. Для каждого натурального числа в промежутке от m до n
 * вывести все делители, кроме единицы и самого числа. m и n вводятся с клавиатуры.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.util.Scanner;

public class T7_NaturalNumbersControl {

    public static void main(String[] args) {

        int m;
        int n;
        int counter = 0;
        int balance;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите начальное значение промежутка: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        m = in.nextInt();

        System.out.print("Введите конечное значение промежутка: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        n = in.nextInt();

        for (int i = m; i <= n; i++) {
            System.out.print("Делители числа " + i + (" :"));
            counter = 0;

            for (int j = i - 1; j > 1; j--) {
                balance = i % j;

                if (balance == 0) {
                    System.out.print(" " + j + ",");
                    counter++;
                }
            }


            System.out.print("\b;");

            if (counter == 0) {
                System.out.print("\r ");
            } else {
                System.out.print("\n ");
            }

        }

    }
}
