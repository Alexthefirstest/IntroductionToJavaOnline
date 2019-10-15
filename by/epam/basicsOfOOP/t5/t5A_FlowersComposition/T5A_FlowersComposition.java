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
 * Вариант A. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
 * (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы
 * и упаковка.
 *
 * - класс содержит пользовательский интерфейс и указанные в условиях методы
 *
 */

package by.epam.basicsOfOOP.t5.t5A_FlowersComposition;

import java.util.ArrayList;
import java.util.Scanner;

public class T5A_FlowersComposition {

    public static void main(String[] args) {

        T5A_FlowersComposition fc = new T5A_FlowersComposition();
        Scanner in = new Scanner(System.in);
        Factory factory = new Factory();
        ArrayList<Flowers> chosenFlowers = new ArrayList<>();
        Package chosenPackage = null;

        int option = -1;

        while (option != 5) {
            System.out.print("1 - add flower, 2 - choose package, 3-print flowers, " +
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
                    System.out.print("enter flower name: ");
                    name = in.nextLine();

                    Flowers flower = factory.getFlower(name);

                    if (flower != null) {
                        chosenFlowers.add(flower);
                        System.out.println("flower added");
                    } else {
                        System.out.println("wrong name");
                    }

                    break;
                case 2:

                    System.out.print("inter package name: ");
                    name = in.nextLine();

                    try {
                        chosenPackage = Package.valueOf(name.toUpperCase().trim().replaceAll(" ", "_"));
                        System.out.println("package added");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("wrong name");
                    }
                    break;

                case 3:
                    Flowers.printAllFlowers();
                    break;

                case 4:
                    Package.printAll();
                    break;
                case 5:
                    Flowers[] chosenFlowersArr = new Flowers[chosenFlowers.size()];
                    chosenFlowersArr = chosenFlowers.toArray(chosenFlowersArr);
                    fc.printCheck(chosenPackage, chosenFlowersArr);
                    break;

                default:
                    System.out.println("wrong number");
                    break;
            }
        }

    }

    void printCheck(Package flowersPackage, Flowers... flowers) {

        int rosesCounter = 0;
        int lilyCounter = 0;
        int violetCounter = 0;

        int rosesPrise = 0;
        int lilyPrice = 0;
        int violetPrice = 0;

        Factory factory = new Factory();

        /*подсчет количества каждого цветка*/
        for (int i = 0; i < flowers.length; i++) {

            if (flowersCompare(flowers[i], "rose")) {
                rosesCounter++;
            }

            if (flowersCompare(flowers[i], "lily")) {
                lilyCounter++;
            }

            if (flowersCompare(flowers[i], "violet")) {
                violetCounter++;
            }
        }

        /*печать чека*/
        System.out.println("\nCHECK\n");

        if (rosesCounter != 0) {
            rosesPrise = factory.getFlower("rose").getPrice() * rosesCounter;

            System.out.println("roses quantity: " + rosesCounter + ", price for all: "
                    + rosesPrise);
        }

        if (lilyCounter != 0) {
            lilyPrice = factory.getFlower("lily").getPrice() * lilyCounter;
            System.out.println("lily quantity: " + lilyCounter + ", price for all: "
                    + lilyPrice);
        }

        if (violetCounter != 0) {
            violetPrice = factory.getFlower("violet").getPrice() * violetCounter;
            System.out.println("violet quantity: " + violetCounter + ", price for all: "
                    + violetPrice);
        }

        if (flowersPackage != null) {
            System.out.println(flowersPackage.toString());
        }
        System.out.println("_______________________________________________");
        System.out.println("final price: " + (lilyPrice + rosesPrise + violetPrice
                + (flowersPackage != null ? flowersPackage.getCost() : 0)));

    }

    boolean flowersCompare(Flowers flower, String compareWith) {
        Factory factory = new Factory();

        if (flower.hashCode() == factory.getFlower(compareWith).hashCode()
                || flower.equals(factory.getFlower(compareWith))) {
            return true;
        }
        return false;
    }

}