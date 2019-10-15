/*
 *
 * класс включающий основной набор методов для использования из пользователььского интерфейса
 *
 *
 */

package by.epam.tasks.homeLibrary.booksManagers;

import by.epam.tasks.homeLibrary.booksManagers.compares.*;
import by.epam.tasks.homeLibrary.booksManagers.searchers.Searcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BookManager {

    public BookManager() {

        loadSaves();

    }

    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    private void loadSaves() {

        long maxId = 0L;

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(".\\src\\by\\epam\\tasks\\homeLibrary\\saves\\books.txt"));
            String line = null;

            while ((line = reader.readLine()) != null) {

                String[] bookInformation = line.split("/");

                long id = Integer.parseInt(bookInformation[7]);

                books.add(new Book(bookInformation[0], bookInformation[1], bookInformation[2],
                        Integer.parseInt(bookInformation[3]), Integer.parseInt(bookInformation[4]),
                        bookInformation[5], BookTypes.valueOf(bookInformation[6]), id));

                maxId = (id > maxId) ? id : maxId;
            }


            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            maxId = (maxId > 1000) ? maxId : 1000;
            Book.setIdCounter(maxId);
        }

    }

    /*постраничный вывод*/
    static public void printBooks(ArrayList<Book> books) {

        Scanner in = new Scanner(System.in);
        int choice = 0;
        int i = 0;
        int j = 0;
        int pagesQuantity = (int) Math.ceil((double) books.size() / 20);
        int page = 1;

        while (true) {

            if (i + 20 >= books.size()) {
                j = books.size() - i;
            } else {
                j = 20;
            }

            System.out.println("\nКниг в каталоге: " + books.size());

            for (int q = 0; q < j; q++) {
                System.out.println("\n- " + books.get(q + i).toString());
            }
            System.out.println("____________ страница " + page + " из " + pagesQuantity + " ___________________________");

            int leftBorder = 1;
            int rightBorder = 3;

            if (i > 0) {
                System.out.print("1 - предыдущая страница, ");

            } else {
                leftBorder = 2;
            }

            if (i + 20 < books.size()) {
                System.out.print("2 - следующая страница, ");
            } else {
                rightBorder = 1;
            }

            System.out.print("3 - завершить: ");

            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choice = in.nextInt();


                if (choice != 3 && (choice < leftBorder || choice > rightBorder)) {
                    System.out.print("введите число из списка выше: ");
                }

            } while (choice != 3 && (choice < leftBorder || choice > rightBorder));


            switch (choice) {
                case 1:
                    i -= 20;
                    page--;
                    break;

                case 2:
                    page++;
                    i += 20;
                    break;

                default:
                    return;
            }

        }//while(true)

    }

    public void sortBooksAndPrint() {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 7) {

            System.out.print("1 - сортировка по названию, 2 - сортировка по авторам, 3 - сортировка по году издания," +
                    "\n4 - сортировка издательству, 5 - сортировка по типу книг, 6 - сортировка по id, 7 - выход: ");
            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choice = in.nextInt();

                if (choice < 1 || choice > 7) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choice < 1 || choice > 7);

            switch (choice) {

                case 1:
                    nameCompare();
                    printBooks(books);
                    break;
                case 2:
                    authorsCompare();
                    printBooks(books);
                    break;
                case 3:
                    yearCompare();
                    printBooks(books);
                    break;
                case 4:
                    publishingCompare();
                    printBooks(books);
                    break;
                case 5:
                    typeCompare();
                    printBooks(books);
                    break;

                case 6:
                    idCompare();
                    printBooks(books);
                    break;
            }


        }

    }

    public void nameCompare() {
        Collections.sort(books, new NameCompare());
    }

    public void authorsCompare() {
        Collections.sort(books, new AuthorsCompare());
    }

    public void publishingCompare() {
        Collections.sort(books, new PublishingCompare());
    }

    public void typeCompare() {
        Collections.sort(books, new TypeCompare());
    }

    public void yearCompare() {
        Collections.sort(books, new YearCompare());
    }

    public void idCompare() {
        Collections.sort(books, new IDCompare());
    }


    public void findBook() {

        Scanner in = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {

            System.out.print("\n1 - поиск по названию, 2 - поиск по автору, 3 - поиск по году издания, " +
                    "\n4 - поиск по издательству, 5 - поиск по id, 6 - выход: ");
            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choice = in.nextInt();

                if (choice < 1 || choice > 6) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choice < 1 || choice > 6);

            System.out.println();

            switch (choice) {

                case 1:
                    printBooks(findBooksByName());
                    break;
                case 2:
                    printBooks(findBooksByAuthor());
                    break;
                case 3:
                    printBooks(findBooksByYear());
                    break;
                case 4:
                    printBooks(findBooksByPublishing());
                    break;

                case 5:
                    Book book = findBookByID();

                    if (book != null) {
                        System.out.println(book.toString());
                    } else {
                        System.out.println("книга не найдена");
                    }
                    break;
            }

        }
    }

    public ArrayList<Book> findBooksByName() {

        Scanner in = new Scanner(System.in);
        String name;

        System.out.print("Введите название книги: ");
        name = in.nextLine();

        return Searcher.searchByName(books, name);

    }


    public ArrayList<Book> findBooksByAuthor() {

        Scanner in = new Scanner(System.in);
        String author;

        System.out.print("Введите автора: ");
        author = in.nextLine();

        return Searcher.searchByAuthors(books, author);

    }


    public ArrayList<Book> findBooksByPublishing() {

        Scanner in = new Scanner(System.in);
        String publishing;

        System.out.print("Введите издательство: ");
        publishing = in.nextLine();

        return Searcher.searchByPublishing(books, publishing);

    }


    public ArrayList<Book> findBooksByYear() {

        Scanner in = new Scanner(System.in);
        int year;

        System.out.print("Введите год издания: ");

        while (!in.hasNextInt()) {
            System.out.print("Введите целое число: ");
            in.next();
        }

        year = in.nextInt();

        return Searcher.searchByYear(books, year);
    }

    public Book findBookByID() {

        Scanner in = new Scanner(System.in);
        int id;

        System.out.print("Введите id: ");

        while (!in.hasNextInt()) {
            System.out.print("Введите целое число: ");
            in.next();
        }

        id = in.nextInt();

        return Searcher.searchByID(books, id);
    }

}
