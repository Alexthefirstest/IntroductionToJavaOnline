/*
 *
 *упаковка
 *
 */

package by.epam.basicsOfOOP.t5.t5A_FlowersComposition;

enum Package {
    WHITE_PAPER(10),
    BLACK_PAPER(12),
    RED_PAPER(15);

    int cost;

    Package(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name().toLowerCase() + ", cost: " + cost;
    }

    static void printAll() {

        for (Package pack : values()) {
            System.out.println(pack.toString());
        }
    }

}
