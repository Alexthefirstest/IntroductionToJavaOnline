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
 * -класс содержит:
 *  -методы добавление клиентов
 *  -методы поиска и вывод:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 *
 * и вспомогательные методы
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t8_CustomersManager;

import java.util.ArrayList;
import java.util.Scanner;

public class T8_CustomersManager {

    public T8_CustomersManager() {
        customers = new Customer[0];
    }

    public static void main(String[] args) {

        T8_CustomersManager cm = new T8_CustomersManager();
        Scanner in = new Scanner(System.in);
        boolean again = true;

        while (again) {

            System.out.print("\nEnter: 1 - add one customer, 2 - add fixed numbers of customers, " +
                    "3 - adding non fixed quantity of customers, 4 - sort by alphabet and print, " +
                    "\n5 - print customers by using credit cards numbers interval, " +
                    "6 - print all customers, 7 - delete all and exit: ");

            int choice = 10;

            while (choice > 7 || choice < 0) {

                while (!in.hasNextInt()) {
                    System.out.print("pls, inter integer number: ");
                    in.next();
                }

                choice = in.nextInt();

                if (choice > 7 || choice < 0) {
                    System.out.print("pls, inter number from list above: ");
                }

            }

            System.out.println();

            switch (choice) {
                case 1:
                    cm.addCustomer();
                    break;

                case 2:
                    cm.addCustomersFixedQuantity();
                    break;

                case 3:
                    cm.addCustomers();
                    break;

                case 4:
                    cm.printCustomers(cm.customersSorterByAlphabet());
                    break;

                case 5:
                    cm.printCustomers(cm.getCustomersWithCreditCardNumbersInInterval());
                    break;

                case 6:
                    cm.printCustomers(cm.customers);
                    break;

                case 7:
                    again = false;
                    break;

                default:
                    throw new IllegalArgumentException("can't come here, check something");
            }

        }

    }

    private Customer customers[];

    public Customer[] getCustomers() {
        return customers;
    }

    private void addCustomer() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter family name: ");
        String familyName = in.nextLine();

        System.out.print("Enter name: ");
        String name = in.nextLine();

        System.out.print("Enter second name: ");
        String secondName = in.nextLine();

        System.out.print("Enter address: ");
        String address = in.nextLine();

        System.out.print("Enter credit card number: ");

        while (!in.hasNextLong()) {
            System.out.print("number must be integer, try again(: ");
            in.next();
        }

        long creditCardNumber = in.nextLong();

        System.out.print("Enter bill number: ");

        while (!in.hasNextLong()) {
            System.out.print("number must be integer, try again(: ");
            in.next();
        }

        long billNumber = in.nextLong();

        Customer customer = new Customer(familyName, name, secondName, address, creditCardNumber, billNumber);

        /* создание нового массива с дополнительным местом для нового клиета и последующей записью его туда*/
        Customer[] newCustomers = new Customer[customers.length + 1];
        System.arraycopy(customers, 0, newCustomers, 0, customers.length);
        newCustomers[newCustomers.length - 1] = customer;
        customers = newCustomers;

        System.out.println("by.epam.programmingWithClasses.simplestClassesAndObjects.Customer added successfully: " + customer.toString() + "\n");
    }

    private void addCustomersFixedQuantity() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter quantity to add: ");
        while (!in.hasNextInt()) {
            System.out.print("number must be integer, try again(: ");
            in.next();
        }

        int howMany = in.nextInt();


        for (int i = 0; i < howMany; i++) {
            addCustomer();
        }

    }

    private void addCustomers() {

        Scanner in = new Scanner(System.in);
        String anotherOne = " ";

        while (!anotherOne.replace("\\s+", "").equals(".")) {

            addCustomer();

            System.out.print("\nPress \".\" to finish or \"1\" to add new customer: ");

            anotherOne = in.nextLine().replace("\\s+", "");

            while (!anotherOne.equals(".") && !anotherOne.equals("1")) {
                System.out.print("pls, enter symbols from list above: ");
                anotherOne = in.nextLine().replace("\\s+", "");
            }

        }
    }


    private void printCustomers(Customer[] customers) {

        if (customers.length == 0) {
            System.out.println("\ncustomers wasn't find");
        } else {

            for (int i = 0; i < customers.length; i++) {
                System.out.println(customers[i].toString());
            }
        }

    }


    private Customer[] customersSorterByAlphabet() {

        Customer[] sortedCustomers = new Customer[customers.length];
        System.arraycopy(customers, 0, sortedCustomers, 0, customers.length);

        for (int i = sortedCustomers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                String familyNameSecondName = "" + (sortedCustomers[j].getFamilyName() + sortedCustomers[j].getName()
                        + sortedCustomers[j].getSecondName()).replace("\\s+", "");

                String secondCustomerfamilyNameSecondName = "" + (sortedCustomers[j + 1].getFamilyName() +
                        sortedCustomers[j + 1].getName() +
                        sortedCustomers[j + 1].getSecondName()).replace("\\s+", "");

                if (!alphabetCompareWord1FirstestWord2(familyNameSecondName, secondCustomerfamilyNameSecondName)) {
                    Customer customer = sortedCustomers[j];
                    sortedCustomers[j] = sortedCustomers[j + 1];
                    sortedCustomers[j + 1] = customer;
                }

            }

        }

        return sortedCustomers;
    }


    /*
     *метод сравнивает два полученных слова:
     * true - если слова равны или первое первее по алфавиту
     * false - если второе первее по алфавиту
     *
     */

    private static Boolean alphabetCompareWord1FirstestWord2(String word1, String word2) {

        if (word1.equals(word2)) {
            return true;
        }

        int max = word1.length() < word2.length() ? word1.length() : word2.length();

        boolean word1Firstest = false;

        for (int i = 0; i < max; i++) {

            if (word1.charAt(i) < word2.charAt(i)) {
                word1Firstest = true;
                break;
            } else if ((word1.charAt(i) > word2.charAt(i))) {
                word1Firstest = false;
                break;
            }


        }

        return word1Firstest;
    }


    private Customer[] getCustomersWithCreditCardNumbersInInterval() {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter start point: ");

        while (!in.hasNextLong()) {
            System.out.print("number must be integer, try again(: ");
            in.next();
        }

        long startIntervalPoint = in.nextLong();

        System.out.print("Enter finish point: ");

        long finishIntervalPoint = 0;

        do {

            while (!in.hasNextLong()) {
                System.out.print("number must be integer, try again(: ");
                in.next();
            }

            finishIntervalPoint = in.nextLong();

            if (finishIntervalPoint < startIntervalPoint) {
                System.out.print("finish point can't be lower then start, try again(: ");
            }

        } while (finishIntervalPoint < startIntervalPoint);

        ArrayList<Customer> sortedCustomers = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {

            long creditCardNumber = customers[i].getCreditCardNumber();

            if (creditCardNumber >= startIntervalPoint && creditCardNumber <= finishIntervalPoint) {
                sortedCustomers.add(customers[i]);
            }

        }

        Customer[] sortedCustomersarr = new Customer[sortedCustomers.size()];
        sortedCustomersarr = sortedCustomers.toArray(sortedCustomersarr);

        return sortedCustomersarr;
    }


}//class