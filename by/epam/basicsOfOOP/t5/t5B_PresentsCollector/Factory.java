package by.epam.basicsOfOOP.t5.t5B_PresentsCollector;

class Factory {

    public Sweets getSweets(String name) {
        Sweets sweet = null;

        switch (name.replaceAll("\\s+", "").toLowerCase()) {
            case "chocolates":
                sweet = new ChocolateSweets();
                break;
            case "candis":
                sweet = new CandySweets();
                break;
            case "lolipops":
                sweet = new LolipopSweets();
                break;

            default:
                System.out.println("sweets wasn't find");
                sweet = null;
        }
        return sweet;
    }

}
