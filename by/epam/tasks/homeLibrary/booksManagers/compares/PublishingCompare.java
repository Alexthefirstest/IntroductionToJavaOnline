package by.epam.tasks.homeLibrary.booksManagers.compares;

import by.epam.tasks.homeLibrary.booksManagers.Book;

import java.util.Comparator;

public class PublishingCompare implements Comparator<Book> {

    public int compare(Book book1, Book book2) {

        return book1.getPublishing().compareTo(book2.getPublishing());
    }
}
