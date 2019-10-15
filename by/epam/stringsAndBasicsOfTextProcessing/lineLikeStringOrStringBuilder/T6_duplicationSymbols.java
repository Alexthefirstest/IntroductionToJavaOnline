/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  6. Из заданной строки получить новую, повторив каждый символ дважды.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T6_duplicationSymbols {

    public static void main(String[] args) {
        StringBuilder line = new StringBuilder("abcdef li");

        System.out.println(duplicationSymbols(line));

    }

    static public String duplicationSymbol(char symbhol) {

        return "" + symbhol + symbhol;
    }

    static public StringBuilder duplicationSymbols(StringBuilder line) {

        for (int i = 0; i < line.length(); i += 2) {
            line.replace(i, i + 1, duplicationSymbol(line.charAt(i)));
        }

        return line;
    }
}
