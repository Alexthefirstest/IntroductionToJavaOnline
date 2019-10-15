/*
 *
 * начало программы
 *
 *
 */

package by.epam.tasks.homeLibrary.usersInterface;

import by.epam.tasks.homeLibrary.interOperations.Inter;

import java.util.Scanner;

public class StartInterface {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 0;
        Inter inter = new Inter();

        while (choice != 4) {

            System.out.print("1 - войти как пользователь, 2 - войти как администратор, " +
                    "3 - зарегистрироватся, 4 - выйти: ");

            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choice = in.nextInt();

                if (choice < 1 || choice > 4) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choice < 0 || choice > 4);

            switch (choice) {

                case 1:

                    if (inter.usersLogIn()) {
                        UserInterface.main();

                        choice=4;
                    }

                    break;

                case 2:
                    if (inter.adminLogIn()) {
                        AdminInterface.main();
                    }

                    break;

                case 3:

                    if (inter.userSignIn()) {
                        System.out.println("регистрация успешно завершена");
                    }

                    break;

            }

        }

    }

}
