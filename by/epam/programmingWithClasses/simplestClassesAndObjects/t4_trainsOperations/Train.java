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
 * - Класс Train с возможностью задания и полученмия времени отправления в часах и минутах
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t4_trainsOperations;

import java.util.regex.Pattern;

public class Train {

    private String nameOfFinishPoint;
    private int trainNumber;
    private int departureTime;


    public Train(String nameOfFinishPoint, int trainNumber, int departureTimeInMinutes) {
        setNameOfFinishPoint(nameOfFinishPoint);
        setTrainNumber(trainNumber);
        setDepartureTimeInMinutes(departureTimeInMinutes);
    }

    public Train(String nameOfFinishPoint, int trainNumber, String departureTime) {
        setNameOfFinishPoint(nameOfFinishPoint);
        setTrainNumber(trainNumber);
        setDepartureTime(departureTime);
    }


    public String getNameOfFinishPoint() {
        return nameOfFinishPoint;
    }

    public void setNameOfFinishPoint(String nameOfFinishPoint) {
        this.nameOfFinishPoint = nameOfFinishPoint;
    }


    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {

        if (trainNumber % 1 != 0) {
            throw new IllegalArgumentException("В поле \"номер поезда\" должно содержаться целое число");
        }

        this.trainNumber = trainNumber;
    }


    public String getDepartureTime() {

        int hours = departureTime / 60;

        return String.format("%02d:%02d", hours, (departureTime - hours * 60));
    }


    public int getDepartureTimeInMinutes() {

        return departureTime;
    }


    public void setDepartureTime(String departureTimeString) {

        departureTimeString = departureTimeString.replace("\\s+", "");

        if (!Pattern.matches("\\d\\d:\\d\\d", departureTimeString)) {
            throw new IllegalArgumentException("Время необходимо указать в 24-х часовом формате: часы:минуты");
        }

        int departureTime = Integer.parseInt(departureTimeString.replace(":", ""));
        int minutes = (departureTime % 100);

        departureTime = (departureTime / 100) * 60 + minutes;

        if (departureTime > 1440 || departureTime < 0) {
            throw new IllegalArgumentException("Время необходимо указать в 24-х часовом формате: часы:минуты");
        }

        this.departureTime = departureTime;
    }

    public void setDepartureTimeInMinutes(int departureTime) {

        if (departureTime > 1440 || departureTime < 0) {
            throw new IllegalArgumentException("Время в минутах должно быть указанно в пределах от 0 до 1440 включительно");
        }

        this.departureTime = departureTime;
    }

}
