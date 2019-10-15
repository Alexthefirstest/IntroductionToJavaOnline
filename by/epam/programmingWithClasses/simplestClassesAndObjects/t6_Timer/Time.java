/*
 *
 *   Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t6_Timer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {

    public Time() {

        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        System.out.println("Время установленно по умолчанию: 00:00:00");
    }


    public Time(String time) {
        setTime(time);
    }


    private int hours;
    private int minutes;
    private int seconds;


    public void setHours(int hours) {
        this.hours = hours >= 0 && hours <= 24 ? hours : 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes >= 0 && minutes <= 60 ? minutes : 0;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds >= 0 && seconds <= 60 ? seconds : 0;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    /*
    *
    * устанавливает время введенное в формате: hours:minutes:seconds
    * если введены: hours:minutes - секнуды задаются равными нуля
    * если введены только часы - минуты и секнуды равны нулю автоматически
    *
    */
    public void setTime(String timeString) {

        timeString = timeString.replace("\\s+", "");

        int seconds = 0;
        int minutes = 0;
        int hours = 0;

        Pattern pattern = Pattern.compile("(\\d{2})(:(\\d{2}))?(:(\\d{2}))?");
        Matcher matcher = pattern.matcher(timeString);

        if (matcher.find()) {
            hours = matcher.group(1) != null ? Integer.parseInt(matcher.group(1)) : 0;
            minutes = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;
            seconds = matcher.group(5) != null ? Integer.parseInt(matcher.group(5)) : 0;
        }

        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }


    public void changeHours(int positiveOrNegativehours) {
        int hours = this.hours + positiveOrNegativehours;

        while (hours < 0 || hours > 24) {
            hours = hours > 24 ? hours - 24 : hours < 0 ? 24 + hours : hours;
        }

        this.hours = hours;
    }


    public void changeMinutes(int positiveOrNegativeMinutes) {
        int minutes = this.minutes + positiveOrNegativeMinutes;

        int extraHours = minutes >= 0 ? minutes / 60 : minutes / 60 - 1;

        changeHours(extraHours);

        minutes = minutes % 60;

        this.minutes = minutes >= 0 ? minutes : 60 + minutes;
    }

    public void changeSeconds(int positiveOrNegativeSeconds) {
        int seconds = this.seconds + positiveOrNegativeSeconds;

        int extraMinutes = seconds >= 0 ? seconds / 60 : seconds / 60 - 1;

        changeMinutes(extraMinutes);

        seconds = seconds % 60;

        this.seconds = seconds >= 0 ? seconds : 60 + seconds;
    }

}
