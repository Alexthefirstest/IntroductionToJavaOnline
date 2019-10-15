package by.epam.basicsOfOOP.t4_DragonsTreasure.game;

import java.io.Serializable;

class Treasure implements Serializable {

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Treasure(String name, int price) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty");
        }

        if (price < 1) {
            throw new IllegalArgumentException("price can't be less then 1");
        }

        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name + " - price: " + this.price;
    }
}
