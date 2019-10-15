package by.epam.tasks.homeLibrary.booksManagers.compares;

import by.epam.tasks.homeLibrary.booksManagers.Book;
import by.epam.tasks.homeLibrary.booksManagers.BookTypes;

import java.util.Comparator;

public class TypeCompare implements Comparator<Book> {

    public int compare(Book book1, Book book2) {

        if (book1.getType() == book2.getType()) {
            return 0;
        }

       if(book1.getType()==BookTypes.БУМАЖНЫЙ) {
           return -1;
       }
       return 1;
    }
}
