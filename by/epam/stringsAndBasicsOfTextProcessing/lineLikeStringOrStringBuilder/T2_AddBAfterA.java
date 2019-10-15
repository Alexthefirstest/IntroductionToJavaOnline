/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  2. Работа со строкой как с объектом типа String или StringBuilder
 *
 *  2. В строке вставить после каждого символа 'a' символ 'b'
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.lineLikeStringOrStringBuilder;

public class T2_AddBAfterA {

    public static void main(String[] args) {

        String line = "aTTttSSsaaSSt a aa bb";
        System.out.println(addBAfterA(line));
    }

    static public String addBAfterA(String line) {

        return line.replace("a", "ab");
    }

}
