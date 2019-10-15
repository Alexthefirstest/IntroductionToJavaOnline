/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 *  4. Найти произведение квадратов первых ста чисел.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

import java.math.BigInteger;

public class T4_MultiplicationsOfNumbers {

    public static void main(String[] args) {

        BigInteger result= BigInteger.valueOf(1);

        for (int i = 1; i <= 200; i++) {

            result=result.multiply(BigInteger.valueOf(i*i));
        }

        System.out.println("произведение квадратов первых двухсот чисел: " + result);
    }
}
