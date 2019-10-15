/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 *  3. Найти сумму квадратов первых ста чисел.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

public class T3_SquaresSum {

    public static void main(String[] args) {

        int result = 0;

        for (int i = 1; i <= 100; i++) {
            result = result + i * i;
        }

        System.out.print("сумма квадратов первых ста чисел: " + result);
    }
}