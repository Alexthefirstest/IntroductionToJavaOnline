/*
 *
 *    Basics of OOP
 *
 *
 *
 *
 *  Задача 4.
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * Приложение должно быть объектно-, а не процедурно-ориентированным.
 * Каждый класс должен иметь отражающее смысл название и информативный состав.
 * Наследование должно применяться только тогда, когда это имеет смысл.
 * При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * Классы должны быть грамотно разложены по пакетам.
 * Консольное меню должно быть минимальным.
 * Для хранения данных можно использовать файлы.
 *
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
 * дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
 * выбора сокровищ на заданную сумму.
 *
 *- класс содержит пользовательский интерфейс и методы реализующие основные возможности
 *
 */


package by.epam.basicsOfOOP.t4_DragonsTreasure.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;


public class T5_DragonsTreasure implements Serializable {

    private Treasure[] treasures;
    private Treasure[] chosenTreasureByPrice;

    public T5_DragonsTreasure() {

        treasures = new Treasure[100];

        LoadTreasures loadTreasures = new LoadTreasures();

        treasures = loadTreasures.getTreasures();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int option = -5;
        T5_DragonsTreasure dragonsTreasure;

        System.out.print("input 1 to create new game, 2 - load game: ");

        while (option != 1 && option != 2) {

            while (!in.hasNextInt()) {
                System.out.print("pls, inter integer number: ");
                in.next();
            }

            option = in.nextInt();

            if (option != 1 && option != 2) {
                System.out.print("pls, inter number from list above: ");
            }

        }

        if (option == 1) {
            dragonsTreasure = new T5_DragonsTreasure();
        } else {
            dragonsTreasure = T5_DragonsTreasure.loadGame();

            if (dragonsTreasure == null) {
                dragonsTreasure = new T5_DragonsTreasure();
            }

        }


        int choice = 1;

        while (choice < 5 && choice > 0) {

            choice = 10;

            System.out.print("\nEnter: 1 - print all treasures, " +
                    "2 - print much expensive treasure, 3 - choose treasures on fix prise, " +
                    "4 - print chosen treasure, 5 - save game, 6 - exit: ");


            while (choice > 6 || choice < 1) {
                while (!in.hasNextInt()) {
                    System.out.print("pls, inter integer number: ");
                    in.next();
                }
                choice = in.nextInt();

                if (choice > 6 || choice < 1) {
                    System.out.print("pls, inter number from list above: ");
                }
            }

            System.out.println();

            switch (choice) {
                case 1:
                    dragonsTreasure.printAllTreasures();
                    break;

                case 2:
                    dragonsTreasure.printMuchExpensiveTreasure();
                    break;

                case 3:
                    dragonsTreasure.chooseTreasureOnFixCost();
                    break;
                case 4:
                    dragonsTreasure.printChosenTreasure();
                    break;
                case 5:
                    dragonsTreasure.saveGame();
                    break;

                case 6:
                    System.out.println("thanks for playing");
                    break;

                default:
                    throw new IllegalArgumentException("can't come here, check something");

            }

        }
    }


    public void printAllTreasures() {
        System.out.println("All treasures list: ");

        printTreasures(treasures);
    }

    public void printTreasures(Treasure... treasures) {

        for (int i = 0; i < treasures.length; i++) {
            System.out.println(treasures[i].toString());
        }

    }

    public Treasure findMuchExpensiveTreasure() {

        Treasure max = treasures[0];

        for (int i = 1; i < 100; i++) {

            if (treasures[i].getPrice() > max.getPrice()) {
                max = treasures[i];
            }

        }

        return max;
    }

    public void printMuchExpensiveTreasure() {

        System.out.print("Much expensive treasure: ");
        printTreasures(findMuchExpensiveTreasure());
    }

    /*выбор сокровищ на сумму не больше заданной*/
    public void chooseTreasureOnFixCost() {

        ArrayList<Treasure> treasureForChoose = new ArrayList<>(Arrays.asList(treasures));
        ArrayList<Treasure> chosenTreasures = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.print("how much money do you have?: ");

        int fixCost = -1;

        while (fixCost < 0) {

            while (!in.hasNextInt()) {
                System.out.print("pls, inter integer number: ");
                in.next();
            }

            fixCost = in.nextInt();

            if (fixCost < 0) {
                System.out.print("pls, inter a positive number: ");
            }

        }

        boolean oneMoreTime = true;

        while (oneMoreTime == true) {

            System.out.println("you have " + fixCost + " gold and can by something from it: ");

            for (int i = 0; i < treasureForChoose.size(); i++) {

                /*вывод сокровища если его стоимость меньше заданного количества денег*/
                if (treasureForChoose.get(i).getPrice() <= fixCost) {
                    System.out.println("ID: " + (i + 1) + ". " + treasureForChoose.get(i).toString());
                } else {//удаление сокровища из списка в противном случае
                    treasureForChoose.remove(i);
                    i--;
                }

            }

            if (treasureForChoose.size() == 0) {
                System.out.println("you haven't enough money to by anything");
            }


            int choose = treasureForChoose.size() + 10;//такое значение позволяет попасть в while
            String chosenOption = "" + choose;

            while (choose > treasureForChoose.size() || choose < 1) {
                System.out.print("enter id of treasure to choose or  \".\" to finish: ");
                chosenOption = in.nextLine().replaceAll("\\s+", "");

                while (!chosenOption.equals(".") && !Pattern.matches("\\d+", chosenOption)) {
                    System.out.print("incorrect input. Pls, repeat: ");
                    chosenOption = in.nextLine().replaceAll("\\s+", "");
                }

                if (chosenOption.equals(".")) {
                    break;
                }

                choose = Integer.parseInt(chosenOption);

                if (choose > treasureForChoose.size() || choose < 1) {
                    System.out.println("wrong ID");
                }

            }


            if (chosenOption.equals(".")) {
                break;
            }

            System.out.println("treasure successfully added to your shopping basket");
            chosenTreasures.add(treasureForChoose.get(choose - 1));//добавление сокровища в список покупок
            treasureForChoose.remove(choose - 1);//удаление сокровища из магазина

            fixCost -= chosenTreasures.get(chosenTreasures.size() - 1).getPrice();

            System.out.print("enter 1 to choose more or  \".\" to finish: ");
            chosenOption = in.nextLine().replaceAll("\\s+", "");

            while (!chosenOption.equals(".") && !chosenOption.equals("1")) {
                System.out.print("incorrect input. Pls, repeat: ");
                chosenOption = in.nextLine().replaceAll("\\s+", "");
            }

            if (chosenOption.equals(".")) {
                oneMoreTime = false;
            }

        }

        /*запись в массив класса выбранных сокровищ*/
        this.chosenTreasureByPrice = new Treasure[chosenTreasures.size()];
        this.chosenTreasureByPrice = chosenTreasures.toArray(this.chosenTreasureByPrice);
        System.out.println("choice well done");

    }

    public void printChosenTreasure() {

        if (chosenTreasureByPrice == null || chosenTreasureByPrice.length == 0) {
            System.out.println("nothing was chose");
        } else {
            printTreasures(chosenTreasureByPrice);
        }

    }

    public void saveGame() {

        Scanner in = new Scanner(System.in);
        String saveName;

        do {
            System.out.print("enter name of this save using only letters, numbers and \"_\": ");
            saveName = in.nextLine();
        } while (Pattern.matches(".*\\W+.*", saveName));

        saveName = ".\\src\\by.epam.basicsOfOOP.t4_DragonsTreasure.GameSaves\\" + saveName + ".ser";


        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveName));
            oos.writeObject(this);
            oos.close();
            System.out.println("game successfully saved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    static private T5_DragonsTreasure loadGame() {

        Scanner in = new Scanner(System.in);
        String loadName;


        do {
            System.out.print("enter name of save will load using only letters, numbers and \"_\" " +
                    "or input \".\" to create new game: ");
            loadName = in.nextLine();

            if (loadName.replaceAll("//s+", "").equals(".")) {
                return null;
            }

        } while (Pattern.matches(".*\\W+.*", loadName));

        loadName = ".\\src\\by.epam.basicsOfOOP.t4_DragonsTreasure.GameSaves\\" + loadName + ".ser";


        T5_DragonsTreasure dragonsTreasure;
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadName));
            dragonsTreasure = (T5_DragonsTreasure) ois.readObject();
            ois.close();
            System.out.println("save successfully load");
        } catch (Exception ex) {
            System.out.println("wrong file name");
            dragonsTreasure = T5_DragonsTreasure.loadGame();
        }

        return dragonsTreasure;
    }
}