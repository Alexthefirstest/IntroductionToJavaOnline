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
 * -класс Book, спецификация которого приведена ниже. конструкторы, set- и get- методы и
 * метод toString().
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t9_BooksManager;

public class Book {

    Book(String название, String авторы, String издательство, int годИздания, int количествоСтраниц, double цена, String тидПереплета) {
        idCounter++;
        this.название = название;
        this.авторы = авторы;
        this.издательство = издательство;
        this.годИздания = годИздания;
        this.количествоСтраниц = количествоСтраниц;
        this.цена = цена;
        this.тидПереплета = тидПереплета;
    }

    static private int idCounter = 1;

    private int id = idCounter;

    private String название;
    private String авторы;
    private String издательство;
    private int годИздания;
    private int количествоСтраниц;
    private double цена;
    private String тидПереплета;

    public String getНазвание() {
        return название;
    }

    public void setНазвание(String название) {
        this.название = название;
    }

    public String getАвторы() {
        return авторы;
    }

    public void setАвторы(String авторы) {
        this.авторы = авторы;
    }

    public String getИздательство() {
        return издательство;
    }

    public void setИздательство(String издательство) {
        this.издательство = издательство;
    }

    public int getГодИздания() {
        return годИздания;
    }

    public void setГодИздания(int годИздания) {

        if (годИздания <= 0) {
            throw new IllegalArgumentException("год издания должен быть больше нуля");
        }

        this.годИздания = годИздания;
    }

    public int getКоличествоСтраниц() {
        return количествоСтраниц;
    }

    public void setКоличествоСтраниц(int количествоСтраниц) {
        if (количествоСтраниц <= 0) {
            throw new IllegalArgumentException("количество страниц должно быть больше нуля");
        }
        this.количествоСтраниц = количествоСтраниц;
    }

    public double getЦена() {

        return цена;
    }

    public void setЦена(double цена) {
        if (цена < 0) {
            throw new IllegalArgumentException("цена не может быть отрицательной");
        }
        this.цена = цена;
    }

    public String getТидПереплета() {
        return тидПереплета;
    }

    public void setТидПереплета(String тидПереплета) {
        this.тидПереплета = тидПереплета;
    }

    public String toString() {
        return "ID: " + id + ", название: " + название + ", автор(ы): " + авторы + ", издательство: " + издательство + ", год издания: " + годИздания + ", количество страниц: " + количествоСтраниц + ", цена: " + цена + ", тип переплета: " + тидПереплета;
    }
}
