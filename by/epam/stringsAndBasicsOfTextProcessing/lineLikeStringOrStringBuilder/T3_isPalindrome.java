/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  3. Проверить, является ли заданное слово палиндромом
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T3_isPalindrome {

    public static void main(String[] args) {

        StringBuilder line = new StringBuilder("lgegl");
        System.out.println(isPalindrome(line));

    }

    static public boolean isPalindrome(StringBuilder line) {

        return line.toString().contentEquals(line.reverse());
    }

}
