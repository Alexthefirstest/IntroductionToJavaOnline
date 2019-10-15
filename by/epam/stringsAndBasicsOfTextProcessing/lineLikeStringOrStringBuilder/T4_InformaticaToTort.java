/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T4_InformaticaToTort {

    public static void main(String[] args) {

        String line = "информатика";

        System.out.println(informaticaToTort(line));
    }

    static public String informaticaToTort(String line) {

        String tort = "";
        tort += line.charAt(7);
        tort += line.charAt(3);
        tort += line.charAt(4);
        tort += line.charAt(7);

        return tort;
    }
}
