/*
 *
 *бензобак
 *
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t2_Car;

class Tank {

    Tank(int capacity) {

        this.capacity = capacity;
        this.fuelQuantity = 0;
    }


    private int capacity;
    private int fuelQuantity;

    public int getFuelQuantity() {
        return fuelQuantity;
    }


    public boolean areThereFuel() {

        return fuelQuantity > 0 ? true : false;
    }


    /* затраты при работающем двигателе */
    void fuelWaistingForWorkingEngine() {
        if (fuelQuantity > 0) {
            fuelQuantity--;
        } else {
            System.out.println("топливо закончилось");
        }
    }

    /* заправка/отсос */
    void takeOrGetFuel(int fuel) {

        if (fuelQuantity + fuel <= capacity && fuelQuantity + fuel >= 0) {

            fuelQuantity += fuel;
            System.out.println("теперь топлива: " + fuelQuantity);

        } else {

            if (fuel + fuelQuantity > capacity) {

                fuelQuantity = capacity;
                System.out.println("топливо пролилось");

            } else {

                fuelQuantity = 0;
                System.out.println("топливо закончилось");

            }
        }

    }

}//class
