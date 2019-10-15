/*
 *
 * Город
 *
 *создание города с назначением административной единицы: столица или региональный центр
 * только один город может быть помечен как столица
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t3_CountryCreator;

class City {

    City(String name) {
        this.name = name;
        this.administrativeUnit = "nothing";
    }

    City(String name, String administrativeUnit) {
        this.name = name;
        setAdministrativeUnit(administrativeUnit);
    }


    static boolean capitalAlreadyExist = false;


    private String name;
    private String administrativeUnit;


    public void setName(String name) {
        this.name = name;
    }


    /*устанавливает административную единицу*/
    void setAdministrativeUnit(String administrativeUnit) {

        /*региональный центр - если это указано*/
        if (administrativeUnit.toLowerCase().replaceAll("\\s+", "").equals("regionalcenter")) {
            this.administrativeUnit = "regional center";
        } else if (administrativeUnit.trim().toLowerCase().equals("capital")) {

            /*столица - если указано и если еще не создана, иначе "ничего"- не столица и не региональный центр*/
            if (!capitalAlreadyExist) {
                this.administrativeUnit = "capital, regional center";
                System.out.println("capital added and was a regional center automatically: " + getName());
                capitalAlreadyExist = true;
            } else {
                System.out.println("can't exist much then 1 capital, city added without administrative unit");
                this.administrativeUnit = "nothing";
            }

        } else {
            throw new IllegalArgumentException("non valid name of administrative unit, " +
                    "use \"regional center\" or \"capital\"");
        }


    }//method


    public String getName() {
        return name;
    }

    public String getAdministrativeUnit() {
        return administrativeUnit;
    }

}//class
