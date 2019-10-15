/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  1. Работа со строкой как с массивом символов
 *
 *  5. Удалить в строке все лишние пробелы,
 * то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.stringLikeArray;

public class T5_DeleteExtraSpaces {

    public static void main(String[] args) {

        String line = "   some   words   with       spaces        ";
        System.out.println(deleteExtraSpaces(line));
    }

    public static String deleteExtraSpaces(String line) {

        line = line.trim();

        return line.replaceAll("\\s+", " ");
    }

}
