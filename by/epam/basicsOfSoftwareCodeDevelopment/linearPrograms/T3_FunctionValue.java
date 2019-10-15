/*
 *
 * 1. Basics of software code development
 *
 *
 * 1. Линейные программы
 *
 * 3.Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 *  (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦)/(𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦)∗ 𝑡𝑔 𝑥𝑦
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.linearPrograms;

import java.util.Scanner;

public class T3_FunctionValue {

    public static void main(String[] args) {

        double x;
        double y;
        double z;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите x: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        x = in.nextDouble();

        System.out.print("Введите y: ");

        while (!in.hasNextDouble()) {
            System.out.print("Это не число: ");
            in.next();
        }

        y = in.nextDouble();

        z = (Math.sin(x) + Math.cos(y)) * Math.tan((x * y)) / (Math.cos(x) - Math.sin(y));
        System.out.print("result: " + z + " RAD");

    }
}
