/*
 *
 *  Programming with classes
 *
 *
 *  2.Агрегация и композиция
 *
 *  5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
 * возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 *
 *
 * - создание ваучера, вывод информации. выбор и сортировка путевок.
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t5_Vouchers;

public class T5_VouchersManager {

    public T5_VouchersManager() {
        this.vouchers = new Voucher[0];
    }


    public static void main(String[] args) {

        T5_VouchersManager vouchersManager = new T5_VouchersManager();

        vouchersManager.showVoucherTypes();
        vouchersManager.showerTransport();
        vouchersManager.showDays();
        vouchersManager.showFoodOptions();


        System.out.println();
        vouchersManager.addVoucher("Bill", 5684, "rest",
                "train", "twelve", "lunch");

        vouchersManager.addVoucher("Jebediah Kerman", 5683,
                "shopping", "plain", 20, "lunch");

        vouchersManager.addVoucher("Bob", 5783, "rest",
                "plain", 20, "lunch", "breakfast");

        vouchersManager.addVoucher("Key", 3458, "therapy",
                "ship", 12, "lunch", "dinner");

        vouchersManager.addVoucher("Jey", 2486, "cruise",
                "ship", 20, "dinner");

        vouchersManager.addVoucher("Tod", 9752, "excursions",
                "bus", "seven", "lunch", "breakfast");

        vouchersManager.addVoucher("Barny", 4952, "rest",
                "train", 12, "lunch");

        vouchersManager.addVoucher("Jessy", 7495, "shopping",
                "plain", 20, "lunch");

        vouchersManager.addVoucher("Kenny", 8796, "therapy",
                "bus", 7, "dinner");


        System.out.println();
        vouchersManager.printAllVouchers();

        System.out.println();
        Voucher voucher = vouchersManager.chooseVoucherById(2);
        voucher.printInformation();

        System.out.println();
        vouchersManager.printVouchers(vouchersManager.sortVouchersByClientsNameName());

        vouchersManager.printVouchers(vouchersManager.sortVouchersByPassportNumber());

        vouchersManager.printVouchers(vouchersManager.sortVouchersByVouchersType());

        vouchersManager.printVouchers(vouchersManager.sortVouchersByTransport());

        vouchersManager.printVouchers(vouchersManager.sortVouchersByDaysQuantity());
    }


    private Voucher[] vouchers;

    public Voucher[] getVouchers() {
        return vouchers;
    }


    public void addVoucher(String clientName, int passportNumber, String voucherType, String transport,
                           String daysQuantity, String... foodOptions) {

        Voucher voucher = new Voucher(clientName, passportNumber, voucherType, transport, daysQuantity, foodOptions);

        Voucher[] newVouchers = vouchers;
        vouchers = new Voucher[newVouchers.length + 1];
        System.arraycopy(newVouchers, 0, vouchers, 0, newVouchers.length);

        vouchers[vouchers.length - 1] = voucher;

        System.out.println("voucher added successfully: " + voucher.toString());
    }

    public void addVoucher(String clientName, int passportNumber, String voucherType,
                           String transport, int daysQuantity, String... foodOptions) {

        addVoucher(clientName, passportNumber, voucherType, transport,
                DaysQuantity.getNameByRealNumber(daysQuantity), foodOptions);

    }


    public Voucher chooseVoucherById(int id) {
        return vouchers[id - 1];
    }


    public Voucher[] sortVouchersByClientsNameName() {

        Voucher[] vouchers = new Voucher[this.vouchers.length];
        System.arraycopy(this.vouchers, 0, vouchers, 0, vouchers.length);

        for (int i = vouchers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (alphabetCompareWord1FirstestWord2(vouchers[j + 1].getClientName(), vouchers[j].getClientName())) {
                    Voucher voucher = vouchers[j];
                    vouchers[j] = vouchers[j + 1];
                    vouchers[j + 1] = voucher;

                }
            }

        }
        return vouchers;
    }


    public Voucher[] sortVouchersByPassportNumber() {

        Voucher[] vouchers = new Voucher[this.vouchers.length];
        System.arraycopy(this.vouchers, 0, vouchers, 0, vouchers.length);

        for (int i = vouchers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (vouchers[j].getPassportNumber() > vouchers[j + 1].getPassportNumber()) {
                    Voucher voucher = vouchers[j];
                    vouchers[j] = vouchers[j + 1];
                    vouchers[j + 1] = voucher;

                }
            }
        }

        return vouchers;
    }


    public Voucher[] sortVouchersByVouchersType() {

        Voucher[] vouchers = new Voucher[this.vouchers.length];
        System.arraycopy(this.vouchers, 0, vouchers, 0, vouchers.length);

        for (int i = vouchers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (alphabetCompareWord1FirstestWord2(vouchers[j + 1].getVoucherType().toString(), vouchers[j].getVoucherType().toString())) {
                    Voucher voucher = vouchers[j];
                    vouchers[j] = vouchers[j + 1];
                    vouchers[j + 1] = voucher;

                }
            }
        }

        return vouchers;
    }


    public Voucher[] sortVouchersByTransport() {

        Voucher[] vouchers = new Voucher[this.vouchers.length];
        System.arraycopy(this.vouchers, 0, vouchers, 0, vouchers.length);

        for (int i = vouchers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (alphabetCompareWord1FirstestWord2(vouchers[j + 1].getTransport().toString(), vouchers[j].getTransport().toString())) {
                    Voucher voucher = vouchers[j];
                    vouchers[j] = vouchers[j + 1];
                    vouchers[j + 1] = voucher;

                }

            }

        }

        return vouchers;
    }


    public Voucher[] sortVouchersByDaysQuantity() {

        Voucher[] vouchers = new Voucher[this.vouchers.length];
        System.arraycopy(this.vouchers, 0, vouchers, 0, vouchers.length);

        for (int i = vouchers.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (vouchers[j].getDaysQuantity().getRealNumber() > vouchers[j + 1].getDaysQuantity().getRealNumber()) {
                    Voucher voucher = vouchers[j];
                    vouchers[j] = vouchers[j + 1];
                    vouchers[j + 1] = voucher;

                }
            }
        }

        return vouchers;
    }


    /* сравнивает слова, true - если равны или первое первее по алфавиту, false - иначе*/
    public static Boolean alphabetCompareWord1FirstestWord2(String word1, String word2) {


        if (word1.equals(word2)) {
            return true;
        }

        int max = word1.length() < word2.length() ? word1.length() : word2.length();

        boolean word1Firstest = false;

        for (int i = 0; i < max; i++) {

            if (word1.charAt(i) < word2.charAt(i)) {
                word1Firstest = true;
                break;
            } else {
                if ((word1.charAt(i) > word2.charAt(i))) {
                    word1Firstest = false;
                    break;
                }
            }

        }

        return word1Firstest;
    }


    public void printAllVouchers() {

        System.out.println("All vouchers");

        for (int i = 0; i < vouchers.length; i++) {
            vouchers[i].printInformation();
        }

    }


    public void printVouchers(Voucher[] vouchers) {
        System.out.println("Vouchers");

        for (int i = 0; i < vouchers.length; i++) {
            vouchers[i].printInformation();
        }

    }


    void showVoucherTypes() {

        System.out.println("Voucher types: ");

        for (VoucherTypes voucherType : VoucherTypes.values()) {
            System.out.println("- " + voucherType.name().toLowerCase());
        }

    }


    void showerTransport() {

        System.out.println("Transport types: ");
        for (Transport transport : Transport.values()) {
            System.out.println("- " + transport.name().toLowerCase());
        }

    }

    void showFoodOptions() {

        System.out.println("Food options: ");

        for (FoodOptions foodOptions : FoodOptions.values()) {
            System.out.println("- " + foodOptions.name().toLowerCase());
        }

    }


    void showDays() {

        System.out.println("Available days quantity: ");

        for (DaysQuantity daysQuantity : DaysQuantity.values()) {
            System.out.println("- " + daysQuantity.toString().toLowerCase());
        }

    }


}//class




