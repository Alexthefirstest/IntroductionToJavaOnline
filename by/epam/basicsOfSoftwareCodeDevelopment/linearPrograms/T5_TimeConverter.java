/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 *5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
 * Вывестиданное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T5_TimeConverter {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int T;
        int seconds;
        int minutes;
        int hours;
        int balance;

        System.out.print("Введите количество секунд: ");

        while (!in.hasNextInt()) {
            System.out.print("Это не целое число: ");
            in.next();
        }

        T = in.nextInt();

        hours = T / (60 * 60);
        balance = T - hours * (60 * 60);

        minutes = balance / 60;
        balance = balance - minutes * 60;

        seconds = balance;

        System.out.println("converted time: " + hours + "h " + minutes + "m " + seconds + "s");
    }
}
