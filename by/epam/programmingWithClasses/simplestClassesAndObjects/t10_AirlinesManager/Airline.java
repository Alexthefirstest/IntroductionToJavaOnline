/*
 *
 *    Programming with classes
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
 * - класс Airline, спецификация которого приведена ниже.  конструкторы, set- и get- методы
 * и метод toString().
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 *
 *  метода позволяющие переводить дни недели из номеров в названия и обратно
 * и методы позволяющие переводить время часы:минуты в минуты и обратно
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t10_AirlinesManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Airline {

    Airline(String destPoint, int flightNumber, String plainType, int departureTimeInMinutes, int weekDays[]) {
        setDestPoint(destPoint);
        setFlightNumber(flightNumber);
        setPlainType(plainType);
        setDepartureTimeInMinutes(departureTimeInMinutes);
        setWeekDays(weekDays);
    }

    String destPoint;
    int flightNumber;
    String plainType;
    int departureTime; //время хранится в минутах
    int[] weekDays; //дни недели хранятся в числа от 1 до 7


    public String getDestPoint() {
        return destPoint;
    }

    public void setDestPoint(String destPoint) {
        this.destPoint = destPoint;
    }


    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }


    public String getPlainType() {
        return plainType;
    }

    public void setPlainType(String plainType) {
        this.plainType = plainType;
    }


    public String getDepartureTime() {
        int hours = departureTime / 60;

        return String.format("%02d:%02d", hours, (departureTime - hours * 60));
    }

    public int getDepartureTimeInMinutes() {

        return departureTime;
    }


    public void setDepartureTime(String departureTimeString) {
        this.departureTime = DepartureTimeToInt(departureTimeString);
    }

    /*перевод времени из формата часы:минуты в минуты*/
    static int DepartureTimeToInt(String departureTimeString) {

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

        return departureTime;
    }


    public void setDepartureTimeInMinutes(int departureTime) {

        if (departureTime > 1440 || departureTime < 0) {
            throw new IllegalArgumentException("Время в минутах должно быть указанно в пределах от 0 до 1440 включительно");
        }

        this.departureTime = departureTime;
    }


    public int[] getWeekDaysNumbers() {

        return weekDays;
    }

    public String[] getWeekDaysNames() {

        ArrayList<String> weekDaysList = new ArrayList<>();

        for (int i = 0; i < weekDays.length; i++) {

            if (weekDays[i] >= 1 && weekDays[i] <= 7) {

                switch (weekDays[i]) {
                    case 1:
                        weekDaysList.add("понедельник");
                        break;

                    case 2:
                        weekDaysList.add("вторник");
                        break;

                    case 3:
                        weekDaysList.add("среда");
                        break;

                    case 4:
                        weekDaysList.add("четверг");
                        break;

                    case 5:
                        weekDaysList.add("пятница");
                        break;

                    case 6:
                        weekDaysList.add("суббота");
                        break;

                    case 7:
                        weekDaysList.add("воскресенье");
                        break;

                    default:
                        weekDaysList.add("день недели не задан");
                        break;

                }

            }//if

        } //for

        String[] weekDaysArr = new String[weekDaysList.size()];
        weekDaysArr = weekDaysList.toArray(weekDaysArr);
        return weekDaysArr;
    }


    public void setWeekDays(int[] weekDays) {

        for (int i = 0; i < weekDays.length; i++) {
            if (weekDays[i] < 1 || weekDays[i] > 7) {
                throw new IllegalArgumentException("необходимо указать число от 1 до 7");
            }
        }

        this.weekDays = weekDays;
    }


    public void setWeekDays(String[] weekDays) {
        this.weekDays = weekDaysToWeekDaysNumbers(weekDays);
    }

    /*дни недели из названий в числа от 0 до 7 с помощью другого метода*/
    static int[] weekDaysToWeekDaysNumbers(String[] weekDays) {

        int[] weekDaysArr = new int[0];
        int[] arrForNumber = new int[1];

        for (int i = 0; i < weekDays.length; i++) {

            arrForNumber[0] = weekDayToWeekDayNumber(weekDays[i]);

            weekDaysArr = IntStream.concat(Arrays.stream(weekDaysArr), Arrays.stream(arrForNumber)).toArray();
        }

        return weekDaysArr;
    }

    /*получить номер дня недели по названию*/
    static int weekDayToWeekDayNumber(String weekDay) {

        switch (weekDay.toLowerCase().trim()) {
            case "понедельник":
                return 1;

            case "вторник":
                return 2;

            case "среда":
                return 3;

            case "четверг":
                return 4;

            case "пятница":
                return 5;

            case "суббота":
                return 6;

            case "воскресенье":
                return 7;

            default:
                throw new IllegalArgumentException("день недели указан неверно");
        }

    }


    public String toString() {
        return "Пункт назначения: " + destPoint + ", номер рейса: " + flightNumber + ", тип самолета: " + plainType + ", время вылета: " + getDepartureTime() + ", дни недели: " + Arrays.toString(getWeekDaysNames());
    }

}
