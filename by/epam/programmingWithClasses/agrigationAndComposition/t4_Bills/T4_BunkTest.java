/*
 *
 *  Programming with classes
 *
 *
 *  2.Агрегация и композиция
 *
 *  4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
 * счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
 * всем счетам, имеющим положительный и отрицательный балансы отдельно
 *
 * - psvm only
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t4_Bills;

public class T4_BunkTest {


    public static void main(String[] args) {

        Bunk bunk = new Bunk();

        bunk.addClient("Cl1F", "Cl1N", 456845, "Cl1A");

        bunk.addClient("Cl1F", "Cl1N", 456845, "Cl1A");

        bunk.addClient("Cl2F", "Cl2N", 456842, "Cl2A");

        System.out.println();
        bunk.printClientsAll();

        System.out.println();
        int i = 1;
        Client client = bunk.getClients()[i];
        client.printAllBills();

        System.out.println();
        client.addBill();
        client.addBill();
        int j = 1;
        Bill bill = client.getBills()[j];
        System.out.println();
        bill.informationToString();
        bill.increaseBalance(10);
        bill.decreaseBalance(5);
        bill.printInformation();

        System.out.println();
        bill.blockBill();
        bill.printInformation();
        bill.increaseBalance(11);
        bill.decreaseBalance(9);
        bill.printInformation();

        System.out.println();
        client.printAllBills();

        System.out.println();
        bunk.printClientsAll();

        System.out.println();
        bill.unblockBill();
        bill.decreaseBalance(10);
        client.printAllBills();

        System.out.println();
        Client client2 = bunk.getClients()[0];
        client2.addBill();
        Bill billC2 = client2.getBills()[0];
        billC2.increaseBalance(100);

        System.out.println("-_______________-");
        bunk.findAndPrintBill(3);
        System.out.println("");
        bunk.findAndPrintBill(1, 2);


        System.out.println("'______'");
        client.addBill();
        Bill balance = client.getBills()[0];
        Bill balance2 = client.getBills()[2];
        balance.increaseBalance(10);
        balance2.increaseBalance(15);
        System.out.println();
        client.printAllBills();
        System.out.println();

        bunk.printSortedBills(2);

        System.out.println("_____---");

        System.out.println(bunk.findCommonBalance(2));
        System.out.println(bunk.findOnlyBillsPositiveBalance(2));
        System.out.println(bunk.findOnlyBillsNegativeBalance(2));


    }
}//class




