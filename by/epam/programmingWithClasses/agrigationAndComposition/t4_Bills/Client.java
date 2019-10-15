/*
 *
 *  клиент
 *
 * добавление счета
 *
 * вывод информации о клиенте и вывод всех счетов
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t4_Bills;

class Client {

    Client(String familyName, String name, int passportNumber, String address) {
        this(familyName, name, "", passportNumber, address);
    }


    Client(String familyName, String name, String secondName, int passportNumber, String address) {
        this.name = name;
        this.familyName = familyName;
        this.secondName = secondName;
        this.address = address;
        this.passportNumber = passportNumber;

        idCounter++;
        id = idCounter;

        bills = new Bill[0];
    }


    private static int idCounter = 0;

    private int id;
    private String name;
    private String familyName;
    private String secondName;
    private String address;
    private int passportNumber;

    public int getPassportNumber() {
        return passportNumber;
    }


    private Bill[] bills;

    public Bill[] getBills() {
        return bills;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public int getBillsQuantity() {
        return bills.length;
    }


    public void printAllBills() {

        printInformation();
        System.out.println("All bills:");

        if (bills.length == 0) {
            System.out.println("bills are absents");
        }

        for (int i = 0; i < bills.length; i++) {
            System.out.println(bills[i].informationToString());
        }
    }


    public String informationToString() {

        return secondName.isEmpty() ?
                "ID: " + id + ", full name: " + familyName + " " + name + ", passport number: "
                        + passportNumber + ", address: " + address + ", bills quantity: " + getBillsQuantity()

                : "ID: " + id + ", full name: " + familyName + " " + name + ", passport number: "
                + passportNumber + " " + secondName + ", address: " + address + ", bills quantity: " + getBillsQuantity();

    }


    public void addBill() {

        Bill bill = new Bill(informationToString());

        Bill[] newBill = bills;
        bills = new Bill[newBill.length + 1];
        System.arraycopy(newBill, 0, bills, 0, newBill.length);

        System.out.println("Bill added successfully: " + bill.informationToString());

        bills[bills.length - 1] = bill;
    }

    public void printInformation() {
        System.out.println(informationToString());
    }


}//class
