/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 * 8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.util.Scanner;

public class T8_CommonNumbersFinder {

    public static void main(String[] args) {

        long firstNumber;
        long secondNumber;
        int balance2;
        boolean concidences = false;
        boolean notPrinted = false;

        int length1;
        int length2;

        int[] numbers1;
        int[] forPrint;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите первое число: ");

        while (!in.hasNextLong()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        firstNumber = in.nextLong();

        System.out.print("Введите второе число: ");

        while (!in.hasNextLong()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        secondNumber = in.nextLong();

        length1 = String.valueOf(firstNumber).length();
        length2 = String.valueOf(secondNumber).length();

        numbers1 = new int[length1];
        forPrint = new int[length2];

        for (int i = 0; i < length1; i++) {
            numbers1[i] = (int) (firstNumber % 10);
            firstNumber = firstNumber / 10;
        }

        for (int i = 0; i < length2; i++) {
            forPrint[i] = -1;
        }

        System.out.print("Общие цифры указанных чисел: ");

        for (int i = 0; i < length2; i++) {
            balance2 = (int) (secondNumber % 10);
            secondNumber = secondNumber / 10;

            for (int v : forPrint) {

                if (v != balance2) {
                    notPrinted = true;
                } else {
                    notPrinted = false;
                    break;
                }
            }

            if (notPrinted == true) {

                for (int j : numbers1) {

                    if (balance2 == j) {
                        concidences = true;
                        System.out.print(balance2 + ", ");
                        forPrint[i] = balance2;
                        break;
                    }

                }

            }

        }

        System.out.print("\b\b;");

        if (concidences == false) {
            System.out.print("\r Общие цифры у указанных чисел отсутствуют");
        }

    }
}
