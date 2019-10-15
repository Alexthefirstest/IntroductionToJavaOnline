/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  1. Работа со строкой как с массивом символов
 *
 *  4. В строке найти количество чисел.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.stringLikeArray;

public class T4_FindQuantityOfNumbers {

    public static void main(String[] args) {

        String line = "   jnm23 sdlfj 54 lksfdj 567jf  kjh 45.8795  87..4684 97846.....846";

        System.out.println(numbersQuantity(line));
    }

    static public String keepOnlyNumbersAndSpaces(String line) {

        line = line.replace("..", "i");
        line = line.replace(".", "");

        return line.replaceAll("\\D+", " ");
    }

    static public int numbersQuantity(String line) {

        line = keepOnlyNumbersAndSpaces(line);
        line = line.trim();
        line = line.replaceAll("\\d", "");

        return line.length() + 1;
    }
}
