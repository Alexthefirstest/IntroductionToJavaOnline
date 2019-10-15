/*
 *
 *  Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
 * и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 *
 * -класс содержит:
 * массив типа Airline, с подходящими конструкторами и методами.
 *
 * методы поиска и вывода:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
 *
 *
 */


package by.epam.programmingWithClasses.simplestClassesAndObjects.t10_AirlinesManager;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class T10_AirlinesManager {

    public T10_AirlinesManager() {
        airlines = new Airline[0];
    }

    private Airline airlines[];

    public Airline[] getAirlines() {
        return airlines;
    }

    public static void main(String[] args) {

        T10_AirlinesManager am = new T10_AirlinesManager();

        System.out.println("\nprint nothing_____________________");
        am.printAirlines(am.airlines);

        System.out.println("\nadd few flights_____________________");
        am.addAirline("Minsk", 123, "Boing 747",
                90, 1);
        am.addAirline("Minsk", 135, "Boing 747",
                "22:40", 2, 6);
        am.addAirline("farfarPlace", 175, "Airbus A320",
                150, "Вторник", "пятница");
        am.addAirline("muchMoreFarPlace", 100500,
                "Concorde", "23:00", "Вторник");

        System.out.println("\nprint flights_____________________");
        am.printAirlines(am.airlines);

        System.out.println("\ndestPoint_____________________");
        am.printAirlines(am.findAirlinesByDestPoint("Minsk"));


        System.out.println("\nweekDay___________________");
        System.out.println("Вт____________");
        am.printAirlines(am.findFlightsByWeekDay("вторник"));

        System.out.println("2_________");
        am.printAirlines(am.findFlightsByWeekDay(2));

        System.out.println("пятница_________");
        am.printAirlines(am.findFlightsByWeekDay("  пяТНица  "));


        System.out.println("\ndayAndTime_____________________");

        System.out.println("2, 22:00____________");
        am.printAirlines(am.findFlightsByWeekDayAndAfterTime(2, "22:00"));

        System.out.println("Вт, 22:00____________");
        am.printAirlines(am.findFlightsByWeekDayAndAfterTime("вторник", "22:00"));

        System.out.println("2, 1320____________");
        am.printAirlines(am.findFlightsByWeekDayAndAfterTime(2, 1320));

        System.out.println("вт, 1320____________");
        am.printAirlines(am.findFlightsByWeekDayAndAfterTime("Вторник", 1320));

    }


    /*
     *
     * конструкторы обеспечивающие возможность задать время в часах:минутах или только минутах
     * и дни недели названиями или номерами
     *
     * */

    public void addAirline(String destPoint, int flightNumber,
                           String plainType, int departureTimeInMinutes, int... weekDay) {

        Airline airline = new Airline(destPoint, flightNumber, plainType, departureTimeInMinutes, weekDay);

        Airline[] newAirline = new Airline[airlines.length + 1];
        System.arraycopy(airlines, 0, newAirline, 0, airlines.length);
        newAirline[newAirline.length - 1] = airline;
        airlines = newAirline;

        System.out.println("airline added successfully: " + airline.toString() + "\n");
    }

    public void addAirline(String destPoint, int flightNumber, String plainType,
                           String departureTime, int... weekDayNumber) {
        addAirline(destPoint, flightNumber, plainType, Airline.DepartureTimeToInt(departureTime), weekDayNumber);
    }

    public void addAirline(String destPoint, int flightNumber,
                           String plainType, int departureTime, String... weekDay) {
        addAirline(destPoint, flightNumber, plainType, departureTime, Airline.weekDaysToWeekDaysNumbers(weekDay));
    }

    public void addAirline(String destPoint, int flightNumber,
                           String plainType, String departureTime, String... weekDay) {
        addAirline(destPoint, flightNumber, plainType, Airline.DepartureTimeToInt(departureTime), Airline.weekDaysToWeekDaysNumbers(weekDay));
    }


    public void printAirlines(Airline[] airlines) {

        if (airlines.length == 0) {
            System.out.println("\nРейсы не найдены");
        } else {

            for (int i = 0; i < airlines.length; i++) {
                System.out.println(airlines[i].toString());
            }

        }

    }


    public Airline[] findAirlinesByDestPoint(String destPoint) {

        ArrayList<Airline> sortedAirlines = new ArrayList<>();

        destPoint = ".*" + destPoint.trim().toLowerCase() + ".*";

        for (int i = 0; i < airlines.length; i++) {

            if (Pattern.matches(destPoint, airlines[i].destPoint.toLowerCase())) {
                sortedAirlines.add(airlines[i]);
            }

        }

        Airline[] sortedAirlinesArr = new Airline[sortedAirlines.size()];
        sortedAirlinesArr = sortedAirlines.toArray(sortedAirlinesArr);
        return sortedAirlinesArr;
    }


    public Airline[] findFlightsByWeekDay(String weekDay) {

        return findFlightsByWeekDay(Airline.weekDayToWeekDayNumber(weekDay));
    }

    public Airline[] findFlightsByWeekDay(int weekDay) {

        ArrayList<Airline> sortedAirlines = new ArrayList<>();

        for (int i = 0; i < airlines.length; i++) {

            boolean find = false;
            int j = 0;

            while (!find && j < airlines[i].weekDays.length) {

                if (weekDay == airlines[i].weekDays[j]) {
                    sortedAirlines.add(airlines[i]);
                    find = true;
                }

                j++;
            }

        }

        Airline[] sortedAirlinesArr = new Airline[sortedAirlines.size()];
        sortedAirlinesArr = sortedAirlines.toArray(sortedAirlinesArr);
        return sortedAirlinesArr;
    }


    /*поисков рейсов после заданного времени*/
    public Airline[] flightsAfterTime(Airline[] airlines, int time) {

        ArrayList<Airline> sortedAirlines = new ArrayList<>();

        for (int i = 0; i < airlines.length; i++) {

            if (airlines[i].getDepartureTimeInMinutes() >= time) {
                sortedAirlines.add(airlines[i]);
            }

        }

        Airline[] sortedAirlinesArr = new Airline[sortedAirlines.size()];
        sortedAirlinesArr = sortedAirlines.toArray(sortedAirlinesArr);
        return sortedAirlinesArr;
    }


    public Airline[] findFlightsByWeekDayAndAfterTime(int weekDay, int time) {
        return flightsAfterTime(findFlightsByWeekDay(weekDay), time);
    }

    public Airline[] findFlightsByWeekDayAndAfterTime(String weekDay, int time) {
        return findFlightsByWeekDayAndAfterTime(Airline.weekDayToWeekDayNumber(weekDay), time);
    }

    public Airline[] findFlightsByWeekDayAndAfterTime(int weekDay, String time) {
        return findFlightsByWeekDayAndAfterTime(weekDay, Airline.DepartureTimeToInt(time));
    }

    public Airline[] findFlightsByWeekDayAndAfterTime(String weekDay, String time) {
        return findFlightsByWeekDayAndAfterTime(Airline.weekDayToWeekDayNumber(weekDay), Airline.DepartureTimeToInt(time));
    }

}//class