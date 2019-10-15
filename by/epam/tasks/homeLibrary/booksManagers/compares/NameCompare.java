package by.epam.tasks.homeLibrary.booksManagers.compares;

import java.util.Comparator;

import by.epam.tasks.homeLibrary.booksManagers.Book;

public class NameCompare implements Comparator<Book> {

    public int compare(Book book1, Book book2) {

        return book1.getName().compareTo(book2.getName());
    }

}
