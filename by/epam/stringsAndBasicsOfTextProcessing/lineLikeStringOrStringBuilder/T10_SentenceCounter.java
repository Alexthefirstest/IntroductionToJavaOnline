/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 * Учитывать только английские буквы.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T10_SentenceCounter {

    public static void main(String[] args) {

        String line = "Hi! Hi? Hi. Madness here!";

        System.out.println(quantityOfSentence(line));
    }

    public static int quantityOfSentence(String line) {

        return T5_HowManyA.HowManySybols(line, '.')
                + T5_HowManyA.HowManySybols(line, '!')
                + T5_HowManyA.HowManySybols(line, '?');
    }

}