/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
 * на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
 * произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
 * позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 *
 * -ничего кроме public static void main
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t5_counter;

import java.util.Arrays;

public class T5_CounterTest {

    public static void main(String[] args) {

        Counter[] c = new Counter[4];

        c[0] = new Counter();
        c[1] = new Counter(5, 4, 6);
        c[2] = new Counter("random", "11", "13");
        c[3] = new Counter("something", "something", "somenthig");

        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i].getCounterLeftBorderRightBorder()));
        }

        System.out.println("__________________________________");

        c[1].counterPlus1();
        System.out.println(Arrays.toString(c[1].getCounterLeftBorderRightBorder()));

        System.out.println("__________________________________");

        c[1].counterPlus1();
        System.out.println(Arrays.toString(c[1].getCounterLeftBorderRightBorder()));

        System.out.println("__________________________________");
        c[1].setCounter(4);
        c[1].counterMinus1();
        System.out.println(Arrays.toString(c[1].getCounterLeftBorderRightBorder()));

    }
}//class



