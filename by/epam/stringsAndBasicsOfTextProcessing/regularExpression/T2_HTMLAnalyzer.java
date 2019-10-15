/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  3.Работа с регулярными выражениями (Pattern, Matcher)
 *
 * 2. Дана строка, содержащая следующий текст (xml-документ)...
 *
 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и
 * его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
 * Пользоваться готовыми парсерами XML для решения данной задачи нельзя.
 */

package by.epam.stringsAndBasicsOfTextProcessing.regularExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class T2_HTMLAnalyzer {

    public static void main(String[] args) {

        String html = "<notes>\n" +
                " <note id = \"1\">\n" +
                " <to>Вася</to>\n" +
                " <from>Света</from>\n" +
                " <heading>Напоминание</heading>\n" +
                " <body>Позвони мне завтра!</body>\n" +
                " </note>\n" +
                " <note id = \"2\">\n" +
                " <to>Петя</to>\n" +
                " <from>Маша</from>\n" +
                " <heading>Важное напоминание</heading>\n" +
                " <body/>\n" +
                " </note>\n" +
                "</notes>\n";


        printResultOfHTMLAnalyzing(html);
    }


    public static String externalTagsOut(String html) {

        Pattern pattern = Pattern.compile("\\A\\s*<\\w+>\\s*\n((.*\n)*)</\\w+>\\n\\z");
        Matcher matcher = pattern.matcher(html);

        String result = "";

        while (matcher.find()) {
            result += (matcher.group(1));
        }

        return result;
    }

    public static String[] dividerIntoNodes(String html) {

        Pattern pattern = Pattern.compile("\\s*<.+>\n(.*\n)*?\\s*</.+>");
        Matcher matcher = pattern.matcher(externalTagsOut(html));

        ArrayList<String> nodes = new ArrayList<String>();

        while (matcher.find()) {
            nodes.add(matcher.group());

        }

        String[] forReturn = new String[nodes.size()];
        forReturn = nodes.toArray(forReturn);
        return forReturn;
    }


    public static String[] nodeAnalyzer(String node) {

        Pattern pattern = Pattern.compile("\\A\\s*<(.+)>\\s*\n((.*\n)*\\s*(<body>.*</body>\n))\\s*<(/.*)>\\s*\\z");
        Matcher matcher = pattern.matcher(node);
        String[] contentAndTypeOfNode = new String[5];

        while (matcher.find()) {
            contentAndTypeOfNode[0] = matcher.group();//содержание узла
            contentAndTypeOfNode[1] = matcher.group(1);//открывающий тег
            contentAndTypeOfNode[2] = matcher.group(5);//закрывающий тег
            contentAndTypeOfNode[3] = matcher.group(2);//содержимое тега
            contentAndTypeOfNode[4] = matcher.group().replace(matcher.group(4), "");//тег без тела

        }

        return contentAndTypeOfNode;
    }


    public static String[][] htmlAnalyzer(String html) {

        String[] nodes = dividerIntoNodes(html);
        String[][] nodesBeenAnalyzed = new String[nodes.length][5];

        for (int i = 0; i < nodes.length; i++) {
            nodesBeenAnalyzed[i] = nodeAnalyzer(nodes[i]);
        }

        return nodesBeenAnalyzed;
    }


    static public void printResultOfHTMLAnalyzing(String html) {

        String[][] nodesBeenAnalyzed = htmlAnalyzer(html);

        for (int i = 0; i < nodesBeenAnalyzed.length; i++) {
            System.out.println();

            if (nodesBeenAnalyzed[i][i] == null) {
                System.out.println("узел № " + (i + 1) + " содеражит ошибку");
            } else {
                System.out.println(Arrays.toString(nodesBeenAnalyzed[i]));
            }
        }
    }

}