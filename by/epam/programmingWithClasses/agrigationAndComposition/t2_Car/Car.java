/*
 *
 * ааавтомобиль
 *
 * создание машины
 * запуск
 * движение
 * смена колеса
 * заправка
 *
 * и методы проверки состояния
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t2_Car;

class Car {

    public Car(String carBrand, int wheelsQuantity, int spareWheelsQuantity, int tankCapacity) {

        if (wheelsQuantity <= 2) {
            throw new IllegalArgumentException("У автомобиля должно быть больше двух колёс");
        }

        if (spareWheelsQuantity < 0) {
            throw new IllegalArgumentException("Количество запасных колес не может быть отрицательным числом");
        }

        if (tankCapacity < 0) {
            throw new IllegalArgumentException("Емкость бака не может быть отрицательным числом");
        }

        this.carBrand = carBrand;
        this.spareWheelsQuantity = spareWheelsQuantity;

        tank = new Tank(tankCapacity);

        wheels = new Wheel[wheelsQuantity];

        for (int i = 0; i < wheelsQuantity; i++) {
            wheels[i] = new Wheel();
        }

        engine = new Engine(wheels, tank);
    }


    public Car(String carBrand, int tankCapacity) {

        this(carBrand, 4, 1, tankCapacity);
        System.out.println("количество колес установленно по умолчанию: 4, запасное колесо: 1");
    }


    private String carBrand;
    private int spareWheelsQuantity;


    Engine engine;
    Wheel[] wheels;
    Tank tank;


    void startEngine() {
        engine.start();
    }


    void move(int distance) {
        engine.moveCar(distance);
    }


    void stopEngine() {
        engine.stop();
    }

    /*заправка*/
    void feelTank(int howMuch) {

        if (howMuch != 0) {

            if (engine.working()) {//проверка работает ли двигатель(при этот топливо уменьшается на 1, если работает)
                /*
                 *если работает - заправка происходит с учетом затрат топлива на работу двигателя,
                 *
                 * так же учитывается вероятность наступления печальных последствий при заправке
                 * работающего двигателя
                 *
                 */

                int forCycle = ((howMuch < 0) && (howMuch > tank.getFuelQuantity())) ?
                        tank.getFuelQuantity() / 3 : howMuch / 3;

                int j = 0;

                for (; j < forCycle; j++) {

                    int blowUp = (int) (Math.random() * 11);

                    if (blowUp == 1) {
                        System.out.println("something go out of plan, don't try to feel working engine next time");
                        System.exit(0);
                    }

                }


                tank.takeOrGetFuel(howMuch - j);

            } else {

                tank.takeOrGetFuel(howMuch);
            }

        }

    }//method


    void changeWheel(int wheelNumber) {

        wheelNumber = wheelNumber - 1;

        if (wheelNumber > wheels.length - 1 || wheelNumber < 0) {
            System.out.println("нет такого колеса");

        } else if (spareWheelsQuantity > 0) {

            wheels[wheelNumber] = new Wheel();
            spareWheelsQuantity--;
            System.out.println("колесо заменено");

            tank.fuelWaistingForWorkingEngine();
        } else {
            System.out.println("нет запасных колес");
        }


    }


    void printCarBrand() {
        System.out.println("Марка автомобиля: " + carBrand);
    }

    void fuelCheck() {
        System.out.println("fuel check: " + tank.getFuelQuantity());
    }

}//class
