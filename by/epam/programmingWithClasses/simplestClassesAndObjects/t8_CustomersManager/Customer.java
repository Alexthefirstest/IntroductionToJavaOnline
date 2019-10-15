/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
 * и методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 *
 *
 * -Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * конструкторы, set- и get- методы и метод toString().
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t8_CustomersManager;

public class Customer {

    Customer(String familyName, String name, String secondName, String address, long creditCardNumber, long billNumber) {
        idCounter++;
        this.familyName = familyName;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.billNumber = billNumber;
    }


    static private int idCounter = 1;

    private int id = idCounter;
    private String familyName;
    private String name;
    private String secondName;
    private String address;
    private long creditCardNumber;
    private long billNumber;


    public int getId() {
        return id;
    }


    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(long billNumber) {
        this.billNumber = billNumber;
    }


    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }


    public String toString() {
        return "ID: " + id + ", full name: " + familyName + " " + name + " " + secondName + ", address: " + address +
                ", credit card number: " + creditCardNumber + ", bill number: " + billNumber;
    }

}
