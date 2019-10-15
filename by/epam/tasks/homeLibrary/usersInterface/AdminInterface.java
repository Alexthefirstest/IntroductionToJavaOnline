/*
 *
 * основной интерфейс с которым работает администратор
 *
 *
 */

package by.epam.tasks.homeLibrary.usersInterface;

import by.epam.tasks.homeLibrary.booksManagers.BookManagerForAdministrator;

import java.util.Scanner;

public class AdminInterface {

    public static void main() {

        Scanner in = new Scanner(System.in);
        BookManagerForAdministrator bmAdmin = new BookManagerForAdministrator();
        int choiceOutside = 0;
        boolean isChanges = false;

        while (choiceOutside != 8) {

            System.out.print("\n1 - добавить книгу, 2 - удалить книгу, 3 - сохранить изменения, " +
                    "4 - вывести на экран список книг, \n5 - изменить данные книги" +
                    ", 6 - найти книгу, 7 - отсортировать книги, 8 - выход: ");

            do {


                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 8) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 8);


            switch (choiceOutside) {

                case 1:
                    bmAdmin.addBooks();
                    isChanges = true;
                    break;

                case 2:
                    bmAdmin.deleteBook();
                    isChanges = true;
                    break;

                case 3:
                    bmAdmin.saveChanges();
                    isChanges = false;
                    break;

                case 4:
                    BookManagerForAdministrator.printBooks(bmAdmin.getBooks());
                    break;

                case 5:
                    bmAdmin.changeBookInformation();
                    isChanges = true;
                    break;

                case 6:
                    bmAdmin.findBook();
                    break;
                case 7:
                    bmAdmin.sortBooksAndPrint();
                    break;

                default:

                    int caseChoice;

                    System.out.print("Вы уверены что хотите выйти? ");

                    if (isChanges == true) {
                        System.out.print(", изменения не были сохранены. ");
                    }

                    System.out.print("1 - да, 2 - нет: ");
                    caseChoice = BookManagerForAdministrator.doChoiceBetween1and2();

                    if (caseChoice == 2) {
                        choiceOutside = 0;
                    }

            }

        }

    }

}
