/*
 *
 *  счет
 *
 * методы блокировки/разблокировки и изменения баланса
 *
 * а так же вывода информации
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t4_Bills;

class Bill {

    Bill(String informationAboutClient) {
        idCounter++;
        id = idCounter;

        this.informationAboutClient = informationAboutClient;
        this.balance = 0;
        unblocked = true;
    }

    private String informationAboutClient;

    public String getInformationAboutClient() {
        return informationAboutClient;
    }

    private static int idCounter = 0;

    private int id;

    private boolean unblocked;

    private long balance;

    public int getId() {
        return id;
    }


    public boolean isUnblocked() {
        return unblocked;
    }


    public void blockBill() {

        if (unblocked == false) {
            System.out.println("already blocked");
        } else {
            this.unblocked = false;
            System.out.println("bill successfully blocked");
        }
    }


    public void unblockBill() {

        if (unblocked == true) {
            System.out.println("already unblocked");
        } else {
            this.unblocked = true;
            System.out.println("bill successfully unblocked");
        }
    }


    public long getBalance() {
        return balance;
    }


    public void increaseBalance(long balance) {

        if (unblocked) {

            if (balance <= 0) {
                System.out.println("pls, enter a positive number");
            } else {
                this.balance += balance;
                System.out.println("balance successfully increased, now: " + getBalance());
            }

        } else {
            System.out.println("illegal operation, bill blocked");
        }

    }


    public void decreaseBalance(long balance) {

        if (unblocked) {

            if (balance <= 0) {
                System.out.println("pls, enter a positive number");
            } else {
                this.balance -= balance;
                System.out.println("balance successfully decreased, now: " + getBalance());
            }

        } else {
            System.out.println("illegal operation, bill blocked");
        }

    }


    public String informationToString() {

        return unblocked ? "ID: " + id + ", balance: " + balance + " - unblocked"
                : "ID: " + id + ", balance: " + balance + " - blocked";
    }


    public void printInformation() {
        System.out.println(informationToString());
    }


    public void printInformationWithClientInformation() {
        System.out.println(informationToString() + "Client: " + informationAboutClient);
    }


}
