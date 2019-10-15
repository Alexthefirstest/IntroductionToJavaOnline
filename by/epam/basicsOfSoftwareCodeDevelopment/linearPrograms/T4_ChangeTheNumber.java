/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 *4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
 * Поменять местами дробную и целую части числа и вывести полученное значение числа.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T4_ChangeTheNumber {

    public static void main(String[] args) {

        int beforePoint;
        double afterPoint;
        int afterPointInt;
        double result;
        double a;

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Введите число вида nnn,ddd: ");

            while (!in.hasNextDouble()) {
                System.out.print("Это не число: ");
                in.next();
            }

            a = in.nextDouble();

            beforePoint = (int) a / 1;
            afterPoint = a - beforePoint;
            afterPointInt = (int) (afterPoint * 1000) / 1;

        } while ((beforePoint < 99 || beforePoint > 1000) || (afterPointInt < 99 || afterPointInt > 1000));

        result = afterPointInt + ((double) beforePoint / 1000);
        System.out.println("result: " + result);

    }
}
