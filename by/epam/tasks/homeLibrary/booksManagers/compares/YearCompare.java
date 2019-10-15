package by.epam.tasks.homeLibrary.booksManagers.compares;

import by.epam.tasks.homeLibrary.booksManagers.Book;

import java.util.Comparator;

public class YearCompare implements Comparator<Book> {

    public int compare(Book book1, Book book2) {

        System.out.println(book1.getYear()+" "+book2.getYear());

        if (book1.getYear() == book2.getYear()) {
            return 0;
        }

        if (book1.getYear() > book2.getYear()) {
            return 1;
        }

        return -1;
    }
}
