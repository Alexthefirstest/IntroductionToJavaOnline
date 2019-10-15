package by.epam.tasks.homeLibrary.booksManagers.searchers;

import by.epam.tasks.homeLibrary.booksManagers.Book;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Searcher {


    static public ArrayList<Book> searchByName(ArrayList<Book> books, String name) {

        ArrayList<Book> foughtBooks = new ArrayList<>();

        name = ".*" + name.toLowerCase().replaceAll("\\s+", "") + ".*";

        for (Book book : books) {

            if (Pattern.matches(name, book.getName().toLowerCase().replaceAll("\\s+", ""))) {
                foughtBooks.add(book);
            }

        }
        return foughtBooks;
    }


    static public ArrayList<Book> searchByAuthors(ArrayList<Book> books, String authors) {

        ArrayList<Book> foughtBooks = new ArrayList<>();

        authors = ".*" + authors.toLowerCase().replaceAll("\\s+", "") + ".*";

        for (Book book : books) {

            if (Pattern.matches(authors, book.getAuthors().toLowerCase().replaceAll("\\s+", ""))) {
                foughtBooks.add(book);
            }

        }
        return foughtBooks;
    }

    static public ArrayList<Book> searchByPublishing(ArrayList<Book> books, String publishing) {

        ArrayList<Book> foughtBooks = new ArrayList<>();

        publishing = ".*" + publishing.toLowerCase().replaceAll("\\s+", "") + ".*";

        for (Book book : books) {

            if (Pattern.matches(publishing, book.getPublishing().toLowerCase().replaceAll("\\s+", ""))) {
                foughtBooks.add(book);
            }

        }
        return foughtBooks;
    }

    static public ArrayList<Book> searchByYear(ArrayList<Book> books, int year) {

        ArrayList<Book> foughtBooks = new ArrayList<>();

        for (Book book : books) {

            if (year == book.getYear()) {
                foughtBooks.add(book);
            }

        }

        return foughtBooks;
    }

    static public Book searchByID(ArrayList<Book> books, int id) {

        for (Book book : books) {

            if (id == book.getId()) {
                return book;
            }

        }

        return null;
    }
}
