/*
 *
 *  банк
 *
 * методы выполняющие поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t4_Bills;

class Bunk {

    public Bunk() {
        this.clients = new Client[0];
        this.bills = new Bill[0];
    }


    private Client[] clients;
    private Bill[] bills;

    public Client[] getClients() {
        return clients;
    }


    public void addClient(String familyName, String name, String secondName, int passportNumber, String address) {

        for (int i = 0; i < clients.length; i++) {

            if (clients[i].getPassportNumber() == passportNumber) {
                System.out.println("Client had been added already");
                return;
            }

        }

        Client client = new Client(familyName, name, secondName, passportNumber, address);

        Client[] newClients = clients;
        clients = new Client[newClients.length + 1];
        System.arraycopy(newClients, 0, clients, 0, newClients.length);

        clients[clients.length - 1] = client;

        System.out.println("Client added successfully: " + client.informationToString());

    }

    public void addClient(String familyName, String name, int passportNumber, String address) {
        addClient(familyName, name, "", passportNumber, address);

    }


    public void printClientsAll() {

        for (int i = 0; i < clients.length; i++) {
            clients[i].printInformation();
        }

    }


    public Bill findBill(int billID, int clientId) {

        Bill[] bills = clients[(clientId - 1)].getBills();


        for (int i = 0; i < bills.length; i++) {
            if (billID == bills[i].getId()) {
                return bills[i];
            }
        }

        return null;
    }

    public Bill findBill(int billID) {

        for (int i = 0; i < clients.length; i++) {

            Bill bill = findBill(billID, clients[i].getId());

            if (bill != null) {
                return bill;
            }
        }

        return null;
    }


    public void findAndPrintBill(int billID) {

        Bill bill = findBill(billID);

        if (bill != null) {
            bill.printInformationWithClientInformation();
        } else {
            System.out.println("find nothing");
        }

    }

    public void findAndPrintBill(int billID, int clientId) {

        Bill bill = findBill(billID, clientId);

        if (bill != null) {
            bill.printInformationWithClientInformation();
        } else {
            System.out.println("find nothing");
        }

    }


    public Bill[] billSorterByBalance(int clientId) {

        Bill[] bills = clients[clientId - 1].getBills();

        for (int i = bills.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (bills[j].getBalance() < bills[j + 1].getBalance()) {
                    Bill bill = bills[j];
                    bills[j] = bills[j + 1];
                    bills[j + 1] = bill;
                }
            }
        }

        return bills;
    }


    public void printSortedBills(int clientId) {

        Bill[] bills = billSorterByBalance(clientId);
        clients[clientId - 1].printInformation();

        for (int i = 0; i < bills.length; i++) {
            bills[i].printInformation();
        }
    }

    public long findCommonBalance(int clientId) {

        Bill[] bills = clients[clientId - 1].getBills();

        long balance = 0L;

        for (int i = 0; i < bills.length; i++) {
            balance += bills[i].getBalance();
        }
        return balance;
    }

    public long findOnlyBillsPositiveBalance(int clientId) {

        Bill[] bills = clients[clientId - 1].getBills();

        long balance = 0L;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i].getBalance() > 0) {
                balance += bills[i].getBalance();
            }
        }
        return balance;
    }

    public long findOnlyBillsNegativeBalance(int clientId) {

        Bill[] bills = clients[clientId - 1].getBills();

        long balance = 0L;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i].getBalance() < 0) {
                balance += bills[i].getBalance();
            }
        }
        return balance;
    }

}//class
