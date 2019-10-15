/*
*
* ваучер
*
* вывод информации о ваучере
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t5_Vouchers;

class Voucher {

    Voucher(String clientName, int passportNumber, String voucherType, String transport,
            String daysQuantity, String... foodOptions) {


        this.clientName = clientName;
        this.passportNumber = passportNumber;

        this.voucherType = VoucherTypes.valueOf(voucherType.trim().toUpperCase());
        this.transport = Transport.valueOf(transport.trim().toUpperCase());
        this.daysQuantity = DaysQuantity.valueOf(daysQuantity.trim().toUpperCase());


        this.foodOptions = new FoodOptions[foodOptions.length];

        for (int i = 0; i < foodOptions.length; i++) {
            this.foodOptions[i] = FoodOptions.valueOf(foodOptions[i].trim().toUpperCase());
        }

        idCounter++;
        id = idCounter;
    }


    static private int idCounter = 0;
    private int id;
    private VoucherTypes voucherType;
    private Transport transport;
    private DaysQuantity daysQuantity;
    private FoodOptions[] foodOptions;
    private String clientName;
    private int passportNumber;

    public int getId() {
        return id;
    }

    public VoucherTypes getVoucherType() {
        return voucherType;
    }

    public Transport getTransport() {
        return transport;
    }

    public DaysQuantity getDaysQuantity() {
        return daysQuantity;
    }

    public FoodOptions[] getFoodOptions() {
        return foodOptions;
    }

    public String getClientName() {
        return clientName;
    }

    public int getPassportNumber() {
        return passportNumber;
    }


    public String foodToString() {

        String foodToString = "";

        for (int i = 0; i < foodOptions.length; i++) {
            foodToString = foodToString + " " + foodOptions[i].name().toLowerCase() + ",";
        }

        foodToString += "\b.";

        return foodToString;
    }

    public String toString() {
        return "ID: " + id + ", client name: " + clientName + ", passport number: " + passportNumber + ". by.epam.programmingWithClasses.agrigationAndComposition.Voucher type: " + voucherType.name().toLowerCase() + ", transport: " + transport.name().toLowerCase() + ", days quantity: " + daysQuantity.name().toLowerCase() + "(" + daysQuantity.getRealNumber() + ")" + ", food: " + foodToString();

    }


    public void printInformation() {
        System.out.println(toString());
    }


}//class
