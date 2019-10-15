/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
 * Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
 * номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 *
 * - Класс содержит:  возможность вывода информации о поезде, номер которого введен пользователем.
 *  возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
 * назначения должны быть упорядочены по времени отправления.
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t4_trainsOperations;

import java.util.Scanner;

public class T4_TrainsManager {

    public static void main(String[] args) {

        Train[] trains = new Train[5];
        trains[0] = addTrain("АФинишн 1", 125, "12:40");
        trains[1] = addTrain("БФинишн 2", 124, 150);
        trains[2] = addTrain("АФинишн 1", 115, "10:00");
        trains[3] = addTrain("БФинишн 4", 119, 1440);
        trains[4] = addTrain("ДФинишн 5", 105, "00:00");

        printTrains(trainSorterByNumbers(trains));
        System.out.println("____________________________________________________________");
        printTrains(findTrain(enterTrainNumber(), trains));
        System.out.println("____________________________________________________________");
        printTrains(trainSorterByFinishPoint(trains));

    }


    static public Train addTrain(String nameOfFinishPoint, int trainNumber, int departureTimeInMinutes) {
        Train train = new Train(nameOfFinishPoint, trainNumber, departureTimeInMinutes);
        return train;
    }

    static public Train addTrain(String nameOfFinishPoint, int trainNumber, String departureTime) {
        Train train = new Train(nameOfFinishPoint, trainNumber, departureTime);
        return train;
    }


    static public void printTrains(Train... trains) {

        for (int i = 0; i < trains.length; i++) {

            if (trains[i] != null) {
                System.out.println("Пункт назначения: " + trains[i].getNameOfFinishPoint() +
                        ", номер поезда: " + trains[i].getTrainNumber()
                        + ", время отправления: " + trains[i].getDepartureTime());
            }

        }

    }


    public static Train[] trainSorterByNumbers(Train... trains) {

        for (int i = trains.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (trains[j].getTrainNumber() > trains[j + 1].getTrainNumber()) {
                    Train train = trains[j];
                    trains[j] = trains[j + 1];
                    trains[j + 1] = train;
                }
            }

        }

        return trains;
    }


    static public int enterTrainNumber() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер поезда: ");

        while (!in.hasNextInt()) {
            System.out.println("Необходимо ввести целое число ");
            in.next();
        }

        return in.nextInt();
    }


    static public Train findTrain(int number, Train... trains) {

        int i = 0;

        while (i < trains.length && trains[i].getTrainNumber() != number) {

            i++;
        }


        if (i == trains.length) {
            System.out.println("Поезд с заданным номером не найден");
            return null;
        }

        return trains[i];
    }


    public static Train[] trainSorterByFinishPoint(Train... trains) {

        for (int i = trains.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                switch (alphabetCompareWord1FirstestWord2(trains[j].getNameOfFinishPoint(),
                        trains[j + 1].getNameOfFinishPoint())) {
                    case 0:
                        if (trains[j].getDepartureTimeInMinutes() > trains[j + 1].getDepartureTimeInMinutes()) {
                            Train train = trains[j];
                            trains[j] = trains[j + 1];
                            trains[j + 1] = train;
                        }
                        break;

                    case 1:
                        break;

                    case 2:
                        Train train = trains[j];
                        trains[j] = trains[j + 1];
                        trains[j + 1] = train;
                        break;

                    default:
                        throw new IllegalArgumentException("someone touched my methods. " +
                                "AlphabetCompareWord1FirstestWord2 couldn't come here");
                }

            }

        }

        return trains;
    }

    /*
     *
     * метод для поиска слова идущего первее по алфавиту, возвращаемые значения:
     * 0- слова равны
     * 1 - первое слово первее
     * 2 - второе слово первее
     *
     */
    public static int alphabetCompareWord1FirstestWord2(String word1, String word2) {

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if (word1.equals(word2)) {
            return 0;
        }

        int max = word1.length() < word2.length() ? word1.length() : word2.length();

        for (int i = 0; i < max; i++) {

            if (word1.charAt(i) < word2.charAt(i)) {
                return 1;
            } else if ((word1.charAt(i) > word2.charAt(i))) {
                return 2;
            }


        }

        return 0;
    }


}//class