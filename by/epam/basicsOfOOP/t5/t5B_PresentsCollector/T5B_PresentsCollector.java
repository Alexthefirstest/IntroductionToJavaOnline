/*
 *
 *    Basics of OOP
 *
 *
 *
 *
 *  Задача 5.
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 *  Корректно спроектируйте и реализуйте предметную область задачи.
 *  Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов
 * проектирования.
 * Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 * для проверки корректности переданных данных можно применить регулярные выражения.
 * Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 * Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
 *
 * Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
 * подарок). Составляющими целого подарка являются сладости и упаковка.
 *
 * - класс содержит пользовательский интерфейс и указанные в условии методы
 *
 */

package by.epam.basicsOfOOP.t5.t5B_PresentsCollector;

import java.util.ArrayList;
import java.util.Scanner;

public class T5B_PresentsCollector {

    public static void main(String[] args) {

        T5B_PresentsCollector pc = new T5B_PresentsCollector();
        Scanner in = new Scanner(System.in);
        Factory factory = new Factory();
        ArrayList<Sweets> sweets = new ArrayList<>();
        Boxes chosenBox = null;

        int option = -1;

        while (option != 5) {
            System.out.print("1 - add sweets, 2 - choose package, 3-print sweets, " +
                    "4 - print packages, 5 - print check and stop: ");

            while (!in.hasNextInt()) {
                System.out.print("pls, inter integer number: ");
                in.next();
            }

            option = in.nextInt();

            in.nextLine();

            String name = null;

            switch (option) {
                case 1:
                    System.out.print("enter sweets name: ");
                    name = in.nextLine();

                    Sweets sweet = factory.getSweets(name);

                    if (sweet != null) {

                        System.out.print("enter sweets muss: ");

                        double muss = -1;


                        while (!in.hasNextDouble()) {
                            System.out.print("enter a number: ");
                            in.nextLine();
                        }

                        muss = in.nextDouble();

                        try {
                            sweet.setMuss(muss);

                            sweets.add(sweet);
                            System.out.println("sweets added");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("wrong mass");
                        }

                    } else {
                        System.out.println("wrong name");
                    }

                    break;
                case 2:

                    System.out.print("inter box name: ");
                    name = in.nextLine();

                    try {

                        int sweetsMuss = 0;

                        chosenBox = Boxes.valueOf(name.toUpperCase().trim().replaceAll(" ", "_"));

                        for (int i = 0; i < sweets.size(); i++) {
                            sweetsMuss += sweets.get(i).getMuss();
                        }

                        if (sweetsMuss > chosenBox.capacity) {

                            System.out.print("place in box isn't enough for chosen sweets, still add this box?: " +
                                    "1- yes, 2 - no: ");

                            if (in.nextInt() != 1) {
                                chosenBox = null;
                                System.out.println("box wasn't added ");
                            } else {
                                System.out.println("box added");
                            }

                        } else {
                            System.out.println("box added");
                        }

                    } catch (IllegalArgumentException ex) {
                        System.out.println("wrong name");
                    }

                    break;

                case 3:
                    Sweets.printAllSweets();
                    break;

                case 4:
                    Boxes.printAll();
                    break;
                case 5:
                    Sweets[] chosenSweetsArr = new Sweets[sweets.size()];
                    chosenSweetsArr = sweets.toArray(chosenSweetsArr);
                    pc.printCheck(chosenBox, chosenSweetsArr);
                    break;

                default:
                    System.out.println("wrong number");
                    break;
            }
        }

    }

    void printCheck(Boxes boxe, Sweets... sweets) {

        int candisMass = 0;
        int lolipopsMass = 0;
        int chocolatesMass = 0;

        int candisPrise = 0;
        int lolipopsPrise = 0;
        int chocolatesPrise = 0;

        Factory factory = new Factory();

        for (int i = 0; i < sweets.length; i++) {

            if (sweetCompare(sweets[i], "candis")) {
                candisMass += sweets[i].getMuss();
            }

            if (sweetCompare(sweets[i], "lolipops")) {
                lolipopsMass += sweets[i].getMuss();
            }

            if (sweetCompare(sweets[i], "chocolates")) {
                chocolatesMass += sweets[i].getMuss();
            }
        }

        /*печать чека*/
        System.out.println("\nCHECK\n");

        if (chocolatesMass > 0) {
            chocolatesPrise = factory.getSweets("chocolates").getPrice() * chocolatesMass;

            System.out.println("chocolates mass: " + chocolatesMass + ", price for all: "
                    + chocolatesPrise);
        }

        if (candisMass > 0) {
            candisPrise = factory.getSweets("candis").getPrice() * candisMass;
            System.out.println("candis mass: " + candisMass + ", price for all: "
                    + candisPrise);
        }

        if (lolipopsMass > 0) {
            lolipopsPrise = factory.getSweets("lolipops").getPrice() * lolipopsMass;
            System.out.println("lolipops mass: " + lolipopsMass + ", price for all: "
                    + lolipopsPrise);
        }

        if (boxe != null) {
            System.out.println(boxe.toString());
        }

        System.out.println("_______________________________________________");
        System.out.println("final price: " + (candisPrise + lolipopsPrise + chocolatesPrise
                + (boxe != null ? boxe.getCost() : 0)));

    }

    boolean sweetCompare(Sweets sweet, String compareWith) {
        Factory factory = new Factory();

        if (sweet.hashCode() == factory.getSweets(compareWith).hashCode()
                || sweet.equals(factory.getSweets(compareWith))) {
            return true;
        }
        return false;
    }

}