/*
 *
 * класс расширяет BookManager класс и используется для организации работы интерфейса администратора
 *
 *
 */

package by.epam.tasks.homeLibrary.booksManagers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class BookManagerForAdministrator extends BookManager {

    public void addBooks() {

        TreeSet<Book> booksTreeSet = new TreeSet<>();
        int choice = 1;

        booksTreeSet.addAll(books);

        while (choice == 1) {

            System.out.print("\n1 - добавить новую книгу, 2 - завершить добавление: ");
            choice = doChoiceBetween1and2();

            if (choice == 1) {
                Book book = addBook();

                int booksTreeSetSize = booksTreeSet.size();

                if (book != null) {
                    booksTreeSet.add(book);

                    if (booksTreeSet.size() != booksTreeSetSize) {
                        System.out.println("книга успешно добавлена в каталог: " + book.toString());
                    } else {
                        System.out.println("книга уже занесена в каталог");
                    }

                } else {
                    System.out.println("книга не добавлена в каталог: ");
                }

            }
        }


        books.clear();
        books.addAll(booksTreeSet);
    }

    private Book addBook() {

        Scanner in = new Scanner(System.in);
        String name;
        String authors;
        String publishing;
        int year;
        int pagesQuantity;
        String coverType;
        BookTypes type = BookTypes.БУМАЖНЫЙ;

        System.out.print("Введите название книги: ");
        name = in.nextLine();
        System.out.print("Введите авторов книги: ");
        authors = in.nextLine();
        System.out.print("Введите издательство: ");
        publishing = in.nextLine();
        System.out.print("Введите год издания: ");

        while (!in.hasNextInt()) {
            System.out.print("год издания - целое число: ");
            in.next();
        }
        year = in.nextInt();

        System.out.print("Введите количество страниц: ");

        do {

            while (!in.hasNextInt()) {
                System.out.print("количество должно быть целым числом: ");
                in.next();
            }
            pagesQuantity = in.nextInt();

            if (pagesQuantity < 0) {
                System.out.print("количество страниц не может быть меньше нуля: ");
            }

        } while (pagesQuantity < 0);

        in.nextLine();

        System.out.print("Введите тип обложки: ");
        coverType = in.nextLine();

        System.out.println("Укажите вариант книги из списка: ");
        BookTypes.printAvailableTypes();

        boolean again = true;

        while (again) {

            try {
                System.out.print("Введите выбранный вариант: ");
                type = BookTypes.valueOf(in.nextLine().toUpperCase().replaceAll("//s+", ""));
                again = false;
            } catch (Exception ex) {
                System.out.println("значение указанно неверно");

            }
        }

        try {

            Book book = new Book(name, authors, publishing, year, pagesQuantity, coverType, type);

            return book;

        } catch (Exception ex) {
            System.out.println("данные заполнены неверно");
        }
        return null;
    }

    /*метод дающий возможность пользователю ввести только число 1 или 2 и возвращающий результат*/
    static public int doChoiceBetween1and2() {

        Scanner in = new Scanner(System.in);
        int choice;

        do {

            while (!in.hasNextInt()) {
                System.out.print("введите целое число: ");
                in.next();
            }
            choice = in.nextInt();

            if (choice < 1 || choice > 2) {
                System.out.print("введите число из предложенных выше: ");
            }

        } while (choice < 0 || choice > 2);

        return choice;
    }

    public void deleteBook() {

        Book book = findBookByID();
        int choice;

        System.out.println();

        System.out.println("1 - удалить книгу, 2 - отменить удаление, выбранная книга: \n" + book.toString());

        choice = doChoiceBetween1and2();

        if (choice == 1) {
            books.remove(book);
            System.out.println("книга удалена");
        } else {
            System.out.println("удаление отменено");
        }

    }

    /*метод дает возможность изменить поля класса Book*/
    public void changeBookInformation() {

        Book book = findBookByID();
        Scanner in = new Scanner(System.in);
        int choice = 0;

        if (book != null) {
            System.out.println("выбранная книга: " + book.toString());
        } else {
            System.out.println("книга не найдена");
            choice = 8;
        }

        while (choice != 8) {

            System.out.print("1 - изменить название, 2 - изменить авторов, 3 - изменить издательство, " +
                    "4 - изменить год издания,\n 5 - изменить количество страниц, 6 - изменить тип обложки, " +
                    "7 - изменить тип книги, 8 - выход: ");
            do {

                while (!in.hasNextInt()) {
                    System.out.println("введите целое число: ");
                    in.next();
                }
                choice = in.nextInt();

                if (choice < 1 || choice > 8) {
                    System.out.print("введите число из предложенных выше: ");
                }

            } while (choice < 1 || choice > 8);

            switch (choice) {

                case 1:
                    rewriteName(book);
                    break;
                case 2:
                    rewriteAuthors(book);
                    break;
                case 3:
                    rewritePublishing(book);
                    break;
                case 4:
                    rewriteYear(book);
                    break;
                case 5:
                    rewritePagesQuantity(book);
                    break;
                case 6:
                    rewriteCoverType(book);
                    break;
                case 7:
                    rewriteBookType(book);
                    break;
            }

        }

    }

    public void rewriteName(Book book) {

        Scanner in = new Scanner(System.in);
        String name;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новое название: ");
        name = in.nextLine();
        book.setName(name);
        System.out.println("имя успешно изменено: " + book.toString());
    }

    public void rewriteAuthors(Book book) {

        Scanner in = new Scanner(System.in);
        String authors;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новых авторов: ");
        authors = in.nextLine();
        book.setAuthors(authors);
        System.out.println("авторы успешно изменены: " + book.toString());
    }

    public void rewritePublishing(Book book) {

        Scanner in = new Scanner(System.in);
        String publishing;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новое издательство: ");
        publishing = in.nextLine();
        book.setPublishing(publishing);
        System.out.println("издательство успешно изменено: " + book.toString());
    }

    public void rewriteYear(Book book) {

        Scanner in = new Scanner(System.in);
        int year;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новый год: ");

        while (!in.hasNextInt()) {
            System.out.print("год издания - целое число: ");
            in.next();
        }
        year = in.nextInt();

        book.setYear(year);
        System.out.println(" год успешно изменен: " + book.toString());

    }

    public void rewritePagesQuantity(Book book) {

        Scanner in = new Scanner(System.in);
        int pagesQuantity;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новое количество страниц: ");

        do {

            while (!in.hasNextInt()) {
                System.out.print("количество должно быть целым числом: ");
                in.next();
            }
            pagesQuantity = in.nextInt();

            if (pagesQuantity < 0) {
                System.out.print("количество страниц не может быть меньше нуля: ");
            }

        } while (pagesQuantity < 0);

        book.setPagesQuantity(pagesQuantity);
        System.out.println("количество страниц успешно изменено: " + book.toString());
    }

    public void rewriteCoverType(Book book) {

        Scanner in = new Scanner(System.in);
        String coverType;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.print("Введите новый тип обложки: ");
        coverType = in.nextLine();
        book.setCoverType(coverType);
        System.out.println("тип обложки успешно изменен: " + book.toString());
    }

    public void rewriteBookType(Book book) {

        Scanner in = new Scanner(System.in);
        BookTypes type = BookTypes.БУМАЖНЫЙ;

        System.out.println("Выбранная книга: " + book.toString());
        System.out.println("Укажите новый вариант книги из списка: ");
        BookTypes.printAvailableTypes();

        boolean again = true;

        while (again) {

            try {
                System.out.print("Введите выбранный вариант: ");
                type = BookTypes.valueOf(in.nextLine().toUpperCase().replaceAll("//s+", ""));
                again = false;
            } catch (Exception ex) {
                System.out.println("значение указанно неверно");

            }
        }

        book.setType(type);
        System.out.println("варинат книги успешно изменен: " + book.toString());
    }


    public void saveChanges() {

        Collections.sort(books);

        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(".\\src\\by\\epam\\tasks\\homeLibrary\\saves\\books.txt"));

            for (Book book : books) {
                writer.write(book.getName() + "/" + book.getAuthors() + "/" + book.getPublishing() + "/" + book.getYear() + "/" +
                        book.getPagesQuantity() + "/" + book.getCoverType() + "/" + book.getType() + "/" + book.getId() + "\n");
            }

            writer.close();
            System.out.println("изменения сохранены");
        } catch (Exception ex) {
            System.out.println("данные не сохранены");
            ex.printStackTrace();
        }

    }

}
