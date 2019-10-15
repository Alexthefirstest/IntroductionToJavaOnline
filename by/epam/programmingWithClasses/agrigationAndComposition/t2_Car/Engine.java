/*
 *
 * двигатель
 *
 * запускается
 * останавливается
 * тратит топливо
 * вращает колёса если есть топливо, если нет - перестает работать
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t2_Car;

class Engine {

    Engine(Wheel[] wheels, Tank tank) {
        this.tank = tank;
        this.wheels = wheels;
        working = false;
    }

    private Wheel[] wheels;

    private Tank tank;

    /*запрашивает бак о наличии топлива*/
    private boolean areThereFuel() {

        if (!tank.areThereFuel()) {
            working = false;
        }

        return tank.areThereFuel();
    }

    /* переменная для проверки работы двигателя(при этом топливо не тратится)*/
    private boolean working;

    /*метод отвечающий за работу двигателя и затраты на это топлива*/
    boolean working() {

        if (working) {
            tank.fuelWaistingForWorkingEngine();
            return areThereFuel();

        } else {
            return false;
        }
    }


    void start() {

        if (!working) {

            System.out.print("врумврум.. ");
            working = true;

            if (working()) {
                System.out.println("вррврврврвррврврврврвр...работает");
            } else {

                System.out.println(" не запустился");
                working = false;
            }

        }
    }


    void stop() {

        System.out.println("двигатель остановлен");
        working = false;
    }


    void moveCar(int distance) {

        int i = 0;

        while (i < distance && working()) {

            for (int j = 0; j < wheels.length; j++) {
                wheels[j].rotating();
            }
            System.out.println();
            i++;

        }

        /*
         *в случае если топли закончилось в пути и двигатеь остановился,
         *необходимо доехать еще одну единицу дистанции, т.к. метод отвечающий за проверку работы спишет
         * топливо на это и остановится, в следствие чего данный метод посчитает что ехать дальше невозможно
         * выражение ниже убирает эту ошибку
         */
        if (i > 0 && i < distance && !working) {

            for (int j = 0; j < wheels.length; j++) {
                wheels[j].rotating();

            }
            System.out.println();
            i++;
        }


        if (!working) {
            System.out.println("двигательне не работает");
        }
        System.out.println("проехали: " + i);
    }

}//class
