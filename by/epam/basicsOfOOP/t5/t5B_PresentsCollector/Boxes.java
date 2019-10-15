package by.epam.basicsOfOOP.t5.t5B_PresentsCollector;

enum Boxes {
    SMALL_BOX(5, 2),
    MIDDLE_BOX(10, 5),
    BIG_BOX(15, 10);

    int cost;
    int capacity;

    public int getCapacity() {
        return capacity;
    }

    Boxes(int cost, int capacity) {
        this.cost = cost;
        this.capacity = capacity;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name().toLowerCase() + ", capacity: " + capacity + ", cost: " + cost;
    }

    static void printAll() {

        for (Boxes box : values()) {
            System.out.println(box.toString());
        }

    }
}
