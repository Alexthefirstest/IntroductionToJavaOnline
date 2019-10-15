/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 * Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T7_repeatAndSpacesDeleter {

    public static void main(String[] args) {

        String line = "abc cde def";

        System.out.println(repeatDeleter(line));

    }


    public static String spaceDeleter(String line) {

        return line.replace(" ", "");
    }


    public static String repeatDeleter(String line) {

        line = spaceDeleter(line);

        for (int i = 0; i < line.length(); i++) {

            char symbol = line.charAt(i);

            line = line.replace("" + symbol, "");

            StringBuilder strLine = new StringBuilder(line);

            strLine.insert(i, symbol);

            line = strLine.toString();

        }

        return line;
    }
}
