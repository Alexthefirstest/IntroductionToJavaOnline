/*
 *
 * основной пользовательский интерфейс
 *
 *
 */

package by.epam.tasks.homeLibrary.usersInterface;

import by.epam.tasks.homeLibrary.booksManagers.BookManager;
import by.epam.tasks.homeLibrary.booksManagers.BookManagerForAdministrator;

import java.util.Scanner;

public class UserInterface {

    public static void main() {

        Scanner in = new Scanner(System.in);
        BookManager bm = new BookManager();
        int choiceOutside = 0;

        while (choiceOutside != 4) {

            System.out.print("\n1 - вывести на экран список книг, 2 - найти книгу, 3 - отсортировать книги, 4 - выход: ");

            do {


                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choiceOutside = in.nextInt();

                if (choiceOutside < 1 || choiceOutside > 4) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choiceOutside < 1 || choiceOutside > 4);


            switch (choiceOutside) {

                case 1:

                    BookManagerForAdministrator.printBooks(bm.getBooks());
                    break;

                case 2:
                    bm.findBook();
                    break;
                case 3:
                    bm.sortBooksAndPrint();
                    break;

            }

        }


    }
}
