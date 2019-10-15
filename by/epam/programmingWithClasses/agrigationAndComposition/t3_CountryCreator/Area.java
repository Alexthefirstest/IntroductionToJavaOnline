/*
 *
 *  area
 *
 * создается из городов
 *
 * не допусакуются одноименные города и наличее больше одного регионального центра
 *
 * задается площадь
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t3_CountryCreator;

import java.util.regex.Pattern;

class Area {

    Area(String name, double square, City... cities) {
        this.name = name;
        this.square = square;
        setCities(cities);
    }

    private double square;
    private String name;
    private City[] cities;


    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public City[] getCities() {
        return cities;
    }


    public void setCities(City... cities) {

        sameCitiesCheck(cities);

        muchOneRegionalCenterCheck(cities);

        this.cities = cities;
    }


    static public void sameCitiesCheck(City... cities) {

        for (int j = 0; j < cities.length - 1; j++) {

            for (int i = j + 1; i < cities.length; i++) {

                if (cities[j].getName().replaceAll("\\s+", "").toLowerCase().equals(cities[i].getName().replaceAll("\\s+", "").toLowerCase())) {
                    throw new IllegalArgumentException("cities can't have the same names");
                }
            }

        }

    }


    static public int muchOneRegionalCenterCheck(City... cities) {

        int regionalCentersCounter = 0;

        for (int i = 0; i < cities.length; i++) {

            if (Pattern.matches(".*regional center.*", cities[i].getAdministrativeUnit())) {
                regionalCentersCounter++;

                if (regionalCentersCounter > 1) {
                    throw new IllegalArgumentException("can't exist much one regional center here");
                }
            }

        }

        return regionalCentersCounter;
    }


}//class
