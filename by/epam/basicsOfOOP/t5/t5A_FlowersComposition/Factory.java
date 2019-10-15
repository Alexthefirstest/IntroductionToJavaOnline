
package by.epam.basicsOfOOP.t5.t5A_FlowersComposition;

class Factory {

    public Flowers getFlower(String name) {
        Flowers flower = null;

        switch (name.replaceAll("\\s+", "").toLowerCase()) {
            case "rose":
                flower = new RoseFlower();
                break;
            case "violet":
                flower = new VioletFlower();
                break;
            case "lily":
                flower = new LilyFlower();
                break;

            default:
                System.out.println("flower wasn't find");
                flower = null;
                break;
        }

        return flower;
    }

}
