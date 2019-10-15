/*
 *
 *  Programming with classes
 *
 *
 *  2.Агрегация и композиция
 *
 *  2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
 * менять колесо, вывести на консоль марку автомобиля.
 *
 * - psvm only
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t2_Car;

public class T2_CarDriver {

    public static void main(String[] args) {

        Car car = new Car("SuperCar", 20);

        System.out.println();
        car.printCarBrand();

        System.out.println("");
        car.move(2);

        System.out.println("");
        car.feelTank(2);
        car.feelTank(22);
        car.feelTank(-30);

        System.out.println("");
        car.startEngine();


        System.out.println("");
        car.feelTank(4);
        car.startEngine();
        car.startEngine();

        System.out.println("");
        car.move(2);
        car.fuelCheck();

        System.out.println("");//пока дошел - топливо закончилось, двигатель заглох, заправлял заглушенный
        car.feelTank(5);
        car.move(2);
        car.startEngine();
        car.fuelCheck();

        System.out.println("");
        car.feelTank(3);
        car.move(15);


        System.out.println("");
        car.feelTank(10);
        car.startEngine();
        car.changeWheel(2);
        car.fuelCheck();

        System.out.println();
        car.stopEngine();
        car.move(4);
        car.feelTank(2);
        car.changeWheel(3);
        car.fuelCheck();
        car.startEngine();
        car.fuelCheck();
        car.stopEngine();
    }

}//class




