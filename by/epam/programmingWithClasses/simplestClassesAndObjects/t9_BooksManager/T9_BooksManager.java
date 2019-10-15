/*
 *
 *   Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
 * метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;c) список книг, выпущенных после заданного года.
 *
 * -класс содержит:
 * метод(psvm) агрегирующий массив типа Book, с подходящими конструкторами и
 * методами
 *
 *  методы поиска и вывода:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;c) список книг, выпущенных после заданного года.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t9_BooksManager;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class T9_BooksManager {

    public static void main(String[] args) {

        T9_BooksManager bc = new T9_BooksManager();

        System.out.println("print nothing_____________________");
        bc.printBooks(bc.books);

        System.out.println("add few books_____________________");
        bc.addBook("Книга1", "Иванов И.И.", "Издательство1",
                1999, 150, 45.20, "мягкий");
        bc.addBook("Книга2", "Иванов К.В., Петров И.И.",
                "Издательство2", 1990, 150, 42.20, "мягкий");
        bc.addBook("Книга3", "Петров И.И.",
                "Издательство1", 2000, 150, 100, "твердый");

        System.out.println("print books_____________________");
        bc.printBooks(bc.books);

        System.out.println("authors search_____________________");

        System.out.println("Иванов И.И.____________");
        bc.printBooks(bc.findBooksByAuthors("Иванов И.И."));

        System.out.println("Иванов_________");
        bc.printBooks(bc.findBooksByAuthors("Иванов"));

        System.out.println("Петров И.И.____________");
        bc.printBooks(bc.findBooksByAuthors("Петров И.И."));

        System.out.println("publisher search\"Издательство1\"___________________");

        bc.printBooks(bc.findBooksByPublishing("Издательство1"));

        System.out.println("year search_____________________");
        bc.printBooks(bc.booksPublishingAfterYear(1999));

    }


    public T9_BooksManager() {
        books = new Book[0];
    }

    private Book books[];

    public Book[] getBooks() {
        return books;
    }


    public void addBook(String название, String авторы, String издательство, int годИздания,
                        int количествоСтраниц, double цена, String типПереплета) {

        Book book = new Book(название, авторы, издательство, годИздания, количествоСтраниц, цена, типПереплета);

        Book[] newBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[newBooks.length - 1] = book;
        books = newBooks;

        System.out.println("Книга успешно добавлена: " + book.toString() + "\n");
    }

    public void printBooks(Book[] books) {

        if (books.length == 0) {
            System.out.println("\nкниги не найдены");
        } else {

            for (int i = 0; i < books.length; i++) {
                System.out.println(books[i].toString());
            }

        }
    }

    public Book[] findBooksByAuthors(String author) {

        ArrayList<Book> sortedBooks = new ArrayList<>();

        author = ".*" + author.trim().toLowerCase() + ".*";

        for (int i = 0; i < books.length; i++) {

            if (Pattern.matches(author, books[i].getАвторы().toLowerCase())) {
                sortedBooks.add(books[i]);
            }

        }

        /*array list to array*/
        Book[] sortedBooksArr = new Book[sortedBooks.size()];
        sortedBooksArr = sortedBooks.toArray(sortedBooksArr);
        return sortedBooksArr;
    }

    public Book[] findBooksByPublishing(String publishing) {

        ArrayList<Book> sortedBooks = new ArrayList<>();

        publishing = ".*" + publishing.trim().toLowerCase() + ".*";

        for (int i = 0; i < books.length; i++) {

            if (Pattern.matches(publishing, books[i].getИздательство().toLowerCase())) {
                sortedBooks.add(books[i]);
            }

        }

        Book[] sortedBooksArr = new Book[sortedBooks.size()];
        sortedBooksArr = sortedBooks.toArray(sortedBooksArr);
        return sortedBooksArr;
    }

    /*
     * метод ищет книги изданные после заданного года
     */

    public Book[] booksPublishingAfterYear(int year) {

        ArrayList<Book> sortedBooks = new ArrayList<>();

        for (int i = 0; i < books.length; i++) {

            if (year <= books[i].getГодИздания()) {
                sortedBooks.add(books[i]);
            }

        }

        Book[] sortedBooksArr = new Book[sortedBooks.size()];
        sortedBooksArr = sortedBooks.toArray(sortedBooksArr);
        return sortedBooksArr;
    }

}//class

