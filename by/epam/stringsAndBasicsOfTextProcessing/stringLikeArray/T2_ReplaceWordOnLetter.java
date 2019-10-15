/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  1. Работа со строкой как с массивом символов
 *
 *  2. Замените в строке все вхождения 'word' на 'letter'.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.stringLikeArray;

public class T2_ReplaceWordOnLetter {

    public static void main(String[] args) {

        String line = "first word, second word, another words: word word word";

        System.out.println(replaceWordOnLetter(line));
    }

    static public String replaceWordOnLetter(String line) {

        return line.replaceAll("\\bword\\b", "letter");
    }
}
