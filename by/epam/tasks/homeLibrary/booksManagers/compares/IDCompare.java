package by.epam.tasks.homeLibrary.booksManagers.compares;

import by.epam.tasks.homeLibrary.booksManagers.Book;

import java.util.Comparator;

public class IDCompare implements Comparator<Book> {

    public int compare(Book book1, Book book2) {

        if (book1.getId() == book2.getId()) {
            return 0;
        }

        if (book1.getId() > book2.getId()) {
            return 1;
        }

        return -1;
    }
}
