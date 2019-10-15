/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T1_MaxSpacesTogether {

    public static void main(String[] args) {

        String line = "1 2  3  4    5     .  3";

        System.out.println(maxSpacesTogether(line));
    }


    static public int maxSpacesTogether(String line) {

        int max = 0;
        int absolutelyMax = 0;

        for (int i = 0; i < line.length(); i++) {

            if (isSpace(line.charAt(i))) {
                max++;
            } else {
                absolutelyMax = max > absolutelyMax ? max : absolutelyMax;
                max = 0;
            }

        }
        return absolutelyMax;
    }

    static public boolean isSpace(char symbol) {

        return symbol == ' ';
    }
}
