/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
 * изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
 * заданное количество часов, минут и секунд.
 *
 * -ничего кроме public static void main
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t6_Timer;

public class T6_TimeTest {

    public static void main(String[] args) {

        Time[] time = new Time[5];

        time[0] = new Time();
        time[1] = new Time("15:20:40");
        time[2] = new Time("16");
        time[3] = new Time("17:21");
        time[4] = new Time("25:40");


        for (int i = 0; i < time.length; i++) {
            System.out.println(time[i].getTime());
        }


        System.out.println("_______________");
        time[0].setTime("16");
        System.out.println(time[0].getTime());
        time[0].setMinutes(64);
        System.out.println(time[0].getTime());
        time[0].changeHours(+2);
        System.out.println(time[0].getTime());
        time[0].changeHours(+20);
        System.out.println(time[0].getTime());
        time[0].changeHours(-25);
        System.out.println(time[0].getTime());
        time[0].changeMinutes(+30);
        System.out.println(time[0].getTime());
        time[0].changeMinutes(+35);
        System.out.println(time[0].getTime());
        time[0].changeSeconds(-29);
        System.out.println(time[0].getTime());
        time[0].changeSeconds(+3630);
        System.out.println(time[0].getTime());
        time[0].changeSeconds(-3630);
        System.out.println(time[0].getTime());
    }

}    //class


