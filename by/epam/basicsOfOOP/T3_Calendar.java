/*
 *
 *    Basics of OOP
 *
 *
 *
 *
 *  Задача 3.
 * Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
 * выходных и праздничных днях.
 *
 *
 */

package by.epam.basicsOfOOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class T3_Calendar {

    public static void main(String[] args) {

        T3_Calendar calendar = new T3_Calendar();

        calendar.addHolidays(2, 6);
        calendar.addHolidays("вторник", "четверг");

        calendar.printHolidaysNumbers();
        calendar.printHolidaysNames();


        System.out.println();
        calendar.addCelebration("23,04");
        calendar.addCelebrations("1,6 ", "23,4");

        calendar.printCelebrationsDates();

    }


    public T3_Calendar() {

        daysForRest = new DaysForRest();

        daysForRest.holidays = new int[0];
        daysForRest.celebrations = new String[0];
    }


    private DaysForRest daysForRest;

    public void addHolidays(int... holidays) {

        for (int i = 0; i < holidays.length; i++) {
            addHoliday(holidays[i]);
        }

    }

    public void addHolidays(String... holidays) {

        for (int i = 0; i < holidays.length; i++) {
            addHoliday(weekDayToWeekDayNumber(holidays[i]));
        }

    }

    private void addHoliday(int holiday) {

        if (holiday > 7 || holiday < 1) {
            throw new IllegalArgumentException("wrong day number");
        }

        if (!isElementInArr(daysForRest.holidays, holiday)) {

            int[] preArr = daysForRest.holidays;
            daysForRest.holidays = new int[preArr.length + 1];
            System.arraycopy(preArr, 0, daysForRest.holidays, 0, preArr.length);

            daysForRest.holidays[daysForRest.holidays.length - 1] = holiday;
        }

    }


    public void addCelebrations(String... celebrations) {

        for (int i = 0; i < celebrations.length; i++) {
            addCelebration(celebrations[i]);
        }

    }

    public void addCelebration(String celebration) {

        celebration = celebration.replaceAll("\\s+", "").replaceAll("\\.", ",");

        if (!Pattern.matches("\\d?\\d,\\d?\\d", celebration)) {
            throw new IllegalArgumentException("wrong date");
        }

        String[] date = (celebration.split(","));
        int day = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);

        if (day > 31 || day < 1 || month > 12 || month < 1) {
            throw new IllegalArgumentException("wrong date");
        }

        celebration = String.format("%02d,%02d", day, month);

        if (!isElementInArr(daysForRest.celebrations, celebration)) {

            String[] preArr = daysForRest.celebrations;
            daysForRest.celebrations = new String[preArr.length + 1];
            System.arraycopy(preArr, 0, daysForRest.celebrations, 0, preArr.length);

            daysForRest.celebrations[daysForRest.celebrations.length - 1] = celebration;

        }

    }

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

    static public boolean isElementInArr(int[] arr, int element) {

        for (int i = 0; i < arr.length; i++) {

            if (element == arr[i]) {
                return true;
            }

        }

        return false;
    }

    static public boolean isElementInArr(String[] arr, String element) {

        for (int i = 0; i < arr.length; i++) {
            if (element.equals(arr[i])) {
                return true;
            }
        }

        return false;
    }


    public void printHolidaysNumbers() {
        System.out.println(Arrays.toString(daysForRest.holidays));
    }

    public void printHolidaysNames() {
        System.out.println(Arrays.toString(getWeekDaysNames()));
    }

    public String[] getWeekDaysNames() {

        ArrayList<String> weekDaysList = new ArrayList<>();

        for (int i = 0; i < daysForRest.holidays.length; i++) {

            switch (daysForRest.holidays[i]) {
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

            }

        } //for

        String[] weekDaysArr = new String[weekDaysList.size()];
        weekDaysArr = weekDaysList.toArray(weekDaysArr);
        return weekDaysArr;
    }


    public void printCelebrationsDates() {
        System.out.println(Arrays.toString(daysForRest.celebrations));
    }

    class DaysForRest {

        private int[] holidays;

        private String[] celebrations;

    }

}
