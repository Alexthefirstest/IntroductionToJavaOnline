/*
 *
 *  Basics of OOP
 *
 *
 *
 *
 *  Задача 2.
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
 * нескольких товаров.
 *
 */

package by.epam.basicsOfOOP;

public class T2_Payment {

    public static void main(String[] args) {

        T2_Payment payment = new T2_Payment();

        payment.printAllProducts();
        System.out.println();

        payment.printCheck();
        System.out.println();

        payment.addProduct("potato");
        payment.addProduct("milk", 2);
        System.out.println();

        payment.printCheck();
    }


    private Products[] products = new Products[0];
    private int sumInCheck = 0;


    public void addProduct(String product) {

        Products[] preProducts = products;
        products = new Products[preProducts.length + 1];
        System.arraycopy(preProducts, 0, products, 0, preProducts.length);

        products[products.length - 1] = Products.valueOf(product.toUpperCase());

        System.out.println("product added: " + products[products.length - 1].toString());

        sumInCheck += products[products.length - 1].prise;

        System.out.println("Result payment: " + sumInCheck + " деняк");
    }


    public void addProduct(String product, int quantity) {

        for (int i = 0; i < quantity; i++) {
            addProduct(product);
        }

    }


    public void printAllProducts() {

        System.out.println("Products list:");

        for (Products product : Products.values()) {
            System.out.println(product.toString());
        }

    }


    public void printCheck() {

        System.out.println("check");

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
        }

        System.out.println("Result payment: " + sumInCheck + " деняк");
    }


    enum Products {

        CHEESE(10), MEET(20), MILK(15), BREED(5), POTATO(7);

        Products(int prise) {
            this.prise = prise;
        }

        private int prise;

        public String toString() {

            return name().toLowerCase() + ", prise is " + prise + " деняк";
        }

    }

}