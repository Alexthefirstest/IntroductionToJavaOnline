/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T5_HowManyA {

    public static void main(String[] args) {

        String line = "abcde cdea, AAA";

        System.out.println(HowManySybols(line, 'a'));

    }

    static public int HowManySybols(String line, char symbol) {

        int symbolCounter = 0;

        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == symbol) {
                symbolCounter++;
            }

        }
        return symbolCounter;
    }

}
