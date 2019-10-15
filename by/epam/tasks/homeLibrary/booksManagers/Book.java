package by.epam.tasks.homeLibrary.booksManagers;

import java.util.Objects;

public class Book implements Comparable<Book> {

    public Book(String name, String authors, String publishing, int year,
                int pagesQuantity, String coverType, BookTypes type) {

        idCounter++;

        this.id = idCounter;
        this.name = name;
        this.authors = authors;
        this.publishing = publishing;
        this.year = year;
        setPagesQuantity(pagesQuantity);
        this.coverType = coverType;
        setType(type);
    }

    Book(String name, String authors, String publishing, int year,
         int pagesQuantity, String coverType, BookTypes type, long id) {

        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publishing = publishing;
        this.year = year;
        setPagesQuantity(pagesQuantity);
        this.coverType = coverType;
        setType(type);
    }

    private static long idCounter = 1000L;
    private long id;
    private String name;
    private String authors;
    private String publishing;
    private int year;
    private int pagesQuantity;
    private String coverType;
    private BookTypes type;

    static void setIdCounter(long idCounter) {
        Book.idCounter = idCounter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        this.year = year;
    }

    public int getPagesQuantity() {
        return pagesQuantity;
    }

    public void setPagesQuantity(int pagesQuantity) {

        if (pagesQuantity < 0) {
            throw new IllegalArgumentException("количесвто страрниц задано неверно");
        }

        this.pagesQuantity = pagesQuantity;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public BookTypes getType() {
        return type;
    }

    public void setType(BookTypes type) {
        this.type = type;
    }

    /*
     *
     *аналог полок в библиотеке - книги по авторам сортируются.
     * а так же дополнительно внутри по названиям
     *
     */
    @Override
    public int compareTo(Book o) {

        int authorsCompare = authors.compareTo(o.authors);

        if (authorsCompare == 0) {

            int nameCompare = name.compareTo(o.name);

            if (nameCompare == 0) {

                if (this.hashCode() != o.hashCode()) {
                    return 1;
                } else if (this.equals(o)) {
                    return 0;
                } else {
                    return 1;
                }

            }

            return nameCompare;

        }
        return authorsCompare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                pagesQuantity == book.pagesQuantity &&
                Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publishing, book.publishing) &&
                Objects.equals(coverType, book.coverType) &&
                type == book.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authors, publishing, year, pagesQuantity, coverType, type);
    }

    public String toString() {
        return "название: " + name + "; авторы: " + authors + "; издательство: "
                + publishing + "; год издания: " + year + "; количество страниц: " + pagesQuantity
                + ";\nтип обложки: " + coverType + "; вариант: " + type.toString().toLowerCase() +
                "; id: " + id;
    }
}
