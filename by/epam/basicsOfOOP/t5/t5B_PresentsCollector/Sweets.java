/*
 *
 *абстрактный класс описывающий конфету
 *
 */

package by.epam.basicsOfOOP.t5.t5B_PresentsCollector;

abstract class Sweets {

    private String name;
    private int price;
    private double muss;

    public double getMuss() {
        return muss;
    }

    public void setMuss(double muss) {
        if (muss > 0) {
            this.muss = muss;
        } else {
            throw new IllegalArgumentException("wrong muss number");
        }
    }

    public Sweets(String name, int price) {
        this.price = price;
        this.name = name;
        this.muss = 0;
    }


    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "name: " + name + ", price of 1 kg: " + price;
    }

    static public void printAllSweets() {

        Factory factory = new Factory();
        System.out.println(factory.getSweets("candis").toString());
        System.out.println(factory.getSweets("lolipops").toString());
        System.out.println(factory.getSweets("chocolates").toString());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweets sweets = (Sweets) o;

        if (name != null ? !name.equals(sweets.name) : sweets.name != null) return false;

        return this.price == sweets.price;
    }

    @Override
    public int hashCode() {

        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
