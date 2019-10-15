package by.epam.programmingWithClasses.agrigationAndComposition.t5_Vouchers;

enum DaysQuantity {

    SEVEN(7),
    TWELVE(12),
    TWENTY(20);

    static String getNameByRealNumber(int realNumber) {

        for (DaysQuantity dc : DaysQuantity.values()) {
            if (dc.getRealNumber() == realNumber) {
                return dc.name();
            }
        }

        return null;
    }


    private int realNumber;

    public int getRealNumber() {
        return realNumber;
    }

    DaysQuantity(int realNumber) {
        this.realNumber = realNumber;
    }


    public String toString() {
        return name() + "(" + realNumber + ")";
    }

}//enum
