/*
 *
 * класс содержит метды дающие право вводить логин и пароль(пароль возвращается зашифрованным)
 *
 *
 */

package by.epam.tasks.homeLibrary.interOperations.logIn;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Pattern;

abstract public class LogIn {

    public static Boolean correctInputCheck(String input) {

        return !Pattern.matches(".*\\W.*", input);

    }

    /*общий метод для ввода данных, когда требуется соответствие ввода указанному в методе correctInputCheck шаблону*/
    private static String enter() {

        Scanner in = new Scanner(System.in);
        String input;

        do {
            input = in.nextLine();

            if (!correctInputCheck(input)) {
                System.out.print("некорректный ввод. \n" +
                        "Разрешено использование только латинских букв, циферных символов и нижнего подчеркивания\n" +
                        "повторите ввод: ");
            }

        } while (!correctInputCheck(input));

        return input;
    }

    public static String enterLogin() {

        System.out.print("Введите логин: ");
        return enter();
    }

    public static String encryptPassword(String password) {

        Base64.Encoder encoder = Base64.getEncoder();
        byte bytes[] = encoder.encode(password.getBytes());

        BigInteger bigInteger = new BigInteger(1, bytes);
        return bigInteger.toString(16);
    }

    public static String enterPasswordAndEncrypt() {

        System.out.print("Введите пароль: ");

        return encryptPassword(enter());
    }
}
