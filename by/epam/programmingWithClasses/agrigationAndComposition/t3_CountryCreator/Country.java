package by.epam.programmingWithClasses.agrigationAndComposition.t3_CountryCreator;

import java.util.ArrayList;
import java.util.regex.Pattern;
/*
 *
 *  country
 *
 * создается из regional
 *
 * должна иметь столицу
 * разные регионы, области и города
 *
 *
 * методы вывода на консоль
 * столицу, количество областей, площадь, областные центры.
 *
 */

class Country {

    public Country(String name, Region... regions) {
        setRegions(regions);
        this.name = name;
        this.regionsQuantity = regions.length;
    }


    Region[] regions;

    public Region[] getRegions() {
        return regions;
    }


    private String name;
    private City capital;
    private int regionsQuantity;
    private double square;
    private City[] regionalCenters;


    private City[] allCity;

    public City[] getAllCity() {
        return allCity;
    }


    public String getName() {
        return name;
    }


    public City getCapital() {
        return capital;
    }


    public int getRegionsQuantity() {
        return regionsQuantity;
    }


    public double getSquare() {
        return square;
    }


    public City[] getRegionalCenters() {
        return regionalCenters;
    }


    static public City[] citiesInCommonArray(Region... regions) {


        int AllCityQuantity = 0;

        //all cities in 1 array
        for (int i = 0; i < regions.length; i++) {
            AllCityQuantity += regions[i].getCitiesInCommonArray().length;
        }

        City[] allCity = new City[AllCityQuantity];


        int preLenght = 0;

        for (int i = 0; i < regions.length; i++) {

            int length = regions[i].getCitiesInCommonArray().length;

            System.arraycopy(regions[i].getCitiesInCommonArray(), 0, allCity, preLenght, length);

            preLenght += length;

        }

        return allCity;
    }


    public void setRegions(Region[] regions) {

        City[] allCity = citiesInCommonArray(regions);
        Area.sameCitiesCheck(allCity);

        this.allCity = allCity;

        regionsNamesTest(regions);

        this.regions = regions;

        capitalAndRegionsCentersFinder();

        squareCounter();
    }


    public void squareCounter() {

        double commonSquare = 0;

        for (int i = 0; i < getRegions().length; i++) {
            commonSquare += regions[i].getSquare();
        }

        this.square = commonSquare;
    }


    public void capitalAndRegionsCentersFinder() {

        ArrayList<City> regionalCenters = new ArrayList<>();

        for (int i = 0; i < allCity.length; i++) {

            if (Pattern.matches(".*regional center.*", allCity[i].getAdministrativeUnit())) {
                regionalCenters.add(allCity[i]);
            }

            if (Pattern.matches(".*capital.*", allCity[i].getAdministrativeUnit())) {
                this.capital = allCity[i];

            }

        }

        if (this.capital == null) {
            throw new IllegalArgumentException("Country must have capital");
        }

        this.regionalCenters = new City[regionalCenters.size()];
        this.regionalCenters = regionalCenters.toArray(this.regionalCenters);

    }


    public void printCapital() {
        System.out.println("capital: " + capital.getName());
    }


    public void printRegionsQuantity() {
        System.out.println("regions quantity: " + regionsQuantity);
    }


    public void printSquare() {
        System.out.println("square: " + square);
    }


    public void printRegionsCenters() {

        System.out.println("region centers:");
        for (int i = 0; i < this.regionalCenters.length; i++) {

            System.out.println(this.regionalCenters[i].getName());

        }

    }


    void regionsNamesTest(Region... regions) {

        for (int j = 0; j < regions.length - 1; j++) {

            for (int i = j + 1; i < regions.length; i++) {

                if (regions[j].getName().replaceAll("\\s+", "").toLowerCase().equals(regions[i].getName().replaceAll("\\s+", "").toLowerCase())) {
                    throw new IllegalArgumentException("regions can't have the same names");
                }

            }

        }
    }


}//class
