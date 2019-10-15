/*
 *
 * абстрактный класс описывающий цветок
 *
 */

package by.epam.basicsOfOOP.t5.t5A_FlowersComposition;

abstract class Flowers {

    private String name;
    private String color;
    private int price;

    public Flowers(String name, String color, int price) {
        this.color = color;
        this.price = price;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "name: " + name + ", color: " + color + ", price: " + price;
    }

    static public void printAllFlowers() {
        Factory factory = new Factory();
        System.out.println(factory.getFlower("rose").toString());
        System.out.println(factory.getFlower("lily").toString());
        System.out.println(factory.getFlower("violet").toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flowers flowers = (Flowers) o;

        if (name != null ? !name.equals(flowers.name) : flowers.name != null) return false;
        if (this.price != flowers.price) return false;
        return color != null ? color.equals(flowers.color) : flowers.color == null;
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

}
