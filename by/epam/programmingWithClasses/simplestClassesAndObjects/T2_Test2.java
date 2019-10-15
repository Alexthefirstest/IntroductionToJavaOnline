/*
 *
 *   Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
 * конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
 * класса.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects;

public class T2_Test2 {

    private T2_Test2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    T2_Test2() {
        System.out.println("Параметры a и b установлены по умолчанию: a=0, b=0");
        a = 0;
        b = 0;
    }

    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
