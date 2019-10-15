/*
 *
 *  Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects;

public class T1_Test1 {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void printAandB() {
        System.out.println("a= " + a + "\nb= " + b);
    }

    public int sumOfAandB() {
        return a + b;
    }

    public int maxOfAandB() {
        return a > b ? a : b;
    }

}
