/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  1. Работа со строкой как с массивом символов
 *
 *  3. В строке найти количество цифр.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.stringLikeArray;

public class T3_FindQuantityOfDigits {

    public static void main(String[] args) {

        String line = "Afdjslf *#$23 5dsfj 4523.dsf-34;";

        System.out.println(digitsQuantity(line));
    }

    static public String deleteAllBesidesDigits(String line) {
        return line.replaceAll("\\D+", "");
    }

    static public int digitsQuantity(String line) {
        return deleteAllBesidesDigits(line).length();
    }
}
