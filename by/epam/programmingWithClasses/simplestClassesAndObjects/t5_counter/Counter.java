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
 *- реализация счетчика
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t5_counter;

import java.util.regex.Pattern;

public class Counter {

    private int counter;
    private int leftBorder;
    private int rightBorder;


    public Counter() {
        this(0, 0, 10);
    }

    public Counter(int counter, int leftBorder, int rightBorder) {

        this.leftBorder = leftBorder;

        if (rightBorder >= leftBorder) {
            this.rightBorder = rightBorder;
        } else {
            throw new IllegalArgumentException("правая граница должна быть больше либо равна левой");
        }

        setCounter(counter);
    }

    /*
     *
     * конструктор ниже получает три значения.
     * 1 - значение счетчика
     * 2 - значение левой границы
     * 3 - значение правой границы
     *
     * если полученное значени - число, устанавливает как значение соответствующей переменной,
     * если не число - заносит в переменную вместо него случайное значение
     *
     */

    public Counter(String... parametrs) {

        if (parametrs.length != 3) {
            throw new IllegalArgumentException("количество параметров должно быть равно трем");
        }

        if (Pattern.matches("\\d+", parametrs[1])) {
            this.leftBorder = (Integer.parseInt(parametrs[1]));
        } else {
            setLeftBorderRandom();
        }

        if (Pattern.matches("\\d+", parametrs[2].replace("//s+", ""))) {

            if (Integer.parseInt(parametrs[2]) >= leftBorder) {
                this.rightBorder = Integer.parseInt(parametrs[2]);
            } else {
                throw new IllegalArgumentException("правая граница должна быть больше либо равна левой");
            }

        } else {
            setRightBorderRandom();
        }


        if (Pattern.matches("\\d+", parametrs[0].replace("//s+", ""))) {
            setCounter(Integer.parseInt(parametrs[0]));
        } else {
            setCounterRandom();
        }

    }


    public int getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(int leftBorder) {
        if (leftBorder <= rightBorder && leftBorder <= counter) {
            this.leftBorder = leftBorder;
        } else {
            if (leftBorder > rightBorder) {
                throw new IllegalArgumentException("левая граница должна быть меньше либо равна правой границе");
            } else {
                throw new IllegalArgumentException("левая граница должна быть меньше либо равна установленному значению счетчика");
            }
        }
    }

    public void setLeftBorderRandom() {
        int a = rightBorder + 1;
        while (a > rightBorder || a > counter) {
            a = (int) (-999999 + Math.random() * 999999999);
        }
        this.leftBorder = a;
    }

    public int[] getCounterLeftBorderRightBorder() {
        int[] result = new int[]{counter, leftBorder, rightBorder};
        return result;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(int rightBorder) {
        if (rightBorder >= leftBorder && rightBorder >= counter) {
            this.rightBorder = rightBorder;
        } else {
            if (rightBorder < leftBorder) {
                throw new IllegalArgumentException("левая граница должна быть меньше правой границы");
            } else {
                throw new IllegalArgumentException("левая граница должна быть меньше либо равна установленному значению счетчика");
            }
        }
    }

    public void setRightBorderRandom() {
        int a = leftBorder - 1;
        while (a < leftBorder || a < counter) {
            a = (int) (-999999 + Math.random() * 999999999);
        }
        this.rightBorder = a;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {

        if (counter <= rightBorder && counter >= leftBorder) {
            this.counter = counter;
        } else {
            throw new IllegalArgumentException("значение счетчика должно находится в пределах установленных границ");
        }
    }

    public void setCounterRandom() {

        int a = getLeftBorder() - 1;

        while (a < leftBorder || a > rightBorder) {
            a = (int) (-999999 + Math.random() * 999999999);
        }

        this.counter = a;
    }


    public void counterPlus1() {

        if (rightBorder > counter) {
            setCounter(counter + 1);
        } else {
            System.out.println("Невозможно увеличить, счетчик достиг верхней границы");
        }

    }

    public void counterMinus1() {

        if (leftBorder < counter) {
            setCounter(counter - 1);
        } else {
            System.out.println("Невозможно уменьшить, счетчик достиг нижней границы");
        }

    }

}