/*
 *
 *  3. Strings and basics of text processing
 *
 *
 *  1. Работа со строкой как с массивом символов
 *
 *  1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 *
 */

package by.epam.stringsAndBasicsOfTextProcessing.stringLikeArray;

import java.util.Arrays;

public class T1_CamelCaseToSnakeCase {

    public static void main(String[] args) {

        String[] camelCaseLine = {"camelCaseToSnakeCase", "replaceWordOnLetterLe", "findQuantityOfDigits", "findQuantityOfNumbers", "deleteExtraSpaces"};

        System.out.println(Arrays.toString(camelCaseToSnakeCase(camelCaseLine)));
    }

    static public String[] camelCaseToSnakeCase(String[] camelCase) {

        for (int i = 0; i < camelCase.length; i++) {
            camelCase[i] = camelCaseToSnakeCase(camelCase[i]);
        }

        return camelCase;
    }

    static public String camelCaseToSnakeCase(String camelCase) {

        int lenght = camelCase.length();

        for (int i = 0; i < lenght; i++) {

            if (Character.isUpperCase(camelCase.charAt(i))) {
                camelCase = camelCase.replace("" + camelCase.charAt(i), (("_") + camelCase.charAt(i)).toLowerCase());
                i++;
            }

        }
        return camelCase;
    }
}