/*
 *
 * 1. Basics of software code development
 *
 *
 * 3. Циклы
 *
 * 6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 *
 */

package by.epam.basicsOfSoftwareCodeDevelopment.cycles;

public class T6_CodePoint {

    public static void main(String[] args) {

        for (int i=0; i<=255;i++){
            System.out.println("Сиволу  " + (char)i +"    в памяти компьютера соответствует численное обозначение " + i );
        }

    }
}
