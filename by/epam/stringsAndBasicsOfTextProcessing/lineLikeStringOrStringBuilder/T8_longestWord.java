/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
 * Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T8_longestWord {

    public static void main(String[] args) {

        String line = "word word word2 looooongestword word12 wordlongest ";

        System.out.println(longestLineElement(line));
    }

    static public String[] stringDeviderBySpaces(String words) {

        return words.split(" ");
    }

    public static String longestLineElement(String line) {

        String[] array = stringDeviderBySpaces(line);
        String max = array[0];

        for (int i = 0; i < array.length; i++) {
            max = array[i].length() > max.length() ? array[i] : max;
        }

        return max;
    }
}
