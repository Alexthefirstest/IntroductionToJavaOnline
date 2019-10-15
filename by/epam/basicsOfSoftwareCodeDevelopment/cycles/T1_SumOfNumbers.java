/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 * 1.  Напишите программу, где пользователь вводит любое целое положительное число.
 * А программа суммирует все числа от 1 до введенного пользователем числа.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.util.Scanner;

public class T1_SumOfNumbers {

    public static void main(String[] args) {

        int finalNumber;
        int result = 0;

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Введите целое положительное число: ");

            while (!in.hasNextInt()) {
                System.out.print("Это не целое число: ");
                in.next();
            }

            finalNumber = in.nextInt();
        } while (finalNumber < 1);

        for (int i = 1; i <= finalNumber; i++) {
            result = result + i;
        }

        System.out.print("Сумма чисел от 1 до " + finalNumber + " = " + result);
    }
}
