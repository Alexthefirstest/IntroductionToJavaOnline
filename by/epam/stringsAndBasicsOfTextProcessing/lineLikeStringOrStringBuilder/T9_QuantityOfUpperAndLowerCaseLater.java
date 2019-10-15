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

import java.util.Arrays;

public class T9_QuantityOfUpperAndLowerCaseLater {

    public static void main(String[] args) {

        String line = "BIGLATERwithsmallAaAa...это считать не должно";

        System.out.println(Arrays.toString(upperAndLongerEngCounter(line)));
    }


    static public int isUpperOrLowerOrRus(char later) {

        int code = (int) later;

        if (code >= 65 && code <= 90) {
            return 1;
        } else if (code >= 97 && code <= 122) {
            return 2;
        } else {
            return 3;
        }

    }

    static public int[] upperAndLongerEngCounter(String line) {

        int[] upperAndLower = new int[2];

        for (int i = 0; i < line.length(); i++) {

            switch (isUpperOrLowerOrRus(line.charAt(i))) {
                case 1:
                    upperAndLower[0]++;
                    break;

                case 2:
                    upperAndLower[1]++;
                    break;
            }
        }
        return upperAndLower;
    }

}
