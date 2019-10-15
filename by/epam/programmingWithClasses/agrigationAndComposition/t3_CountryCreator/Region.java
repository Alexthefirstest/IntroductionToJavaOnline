/*
 *
 *  region
 *
 * создается из area
 *
 * должен быть один региональный центр
 * разные по именам города
 * разные по именам области
 *
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t3_CountryCreator;

class Region {

    Region(String name, Area... areas) {
        this.name = name;
        setRegion(areas);

        commonSquare = 0;
    }


    private String name;
    private double commonSquare;

    private Area[] areas;

    public Area[] getAreas() {
        return areas;
    }


    private double square;

    public double getSquare() {
        return square;
    }


    private City[] citiesInCommonArray;

    public City[] getCitiesInCommonArray() {
        return citiesInCommonArray;
    }

    /*города объеденяются в один массив*/
    public City[] citiesInCommonArray(Area... areas) {

        int AllCityQuantity = 0;

        //all cities in 1 array
        for (int i = 0; i < areas.length; i++) {
            AllCityQuantity += areas[i].getCities().length;
        }

        City[] allCity = new City[AllCityQuantity];

        int preLenght = 0;
        for (int i = 0; i < areas.length; i++) {

            int length = areas[i].getCities().length;

            System.arraycopy(areas[i].getCities(), 0, allCity, preLenght, length);

            preLenght += length;

        }

        return allCity;
    }


    /*проверка на существование именно одного регионального центра*/
    public void setRegion(Area... areas) {

        City[] allCity = citiesInCommonArray(areas);

        Area.sameCitiesCheck(allCity);//проверка на отсутствие одноименных городов, иначе exception

        int regionalCenters =
                Area.muchOneRegionalCenterCheck(allCity);//выбрасывает exception если региональных центров больше 1

        if (regionalCenters < 1) {
            throw new IllegalArgumentException("must exist one regional center");
        }

        this.square = commonSquareFinder(areas);

        this.areas = areas;

        areasNamesTest(areas);

        citiesInCommonArray = allCity;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCommonSquare() {
        return commonSquare;
    }


    void areasNamesTest(Area... areas) {
        for (int j = 0; j < areas.length - 1; j++) {

            for (int i = j + 1; i < areas.length; i++) {

                if (areas[j].getName().replaceAll("\\s+", "").toLowerCase()
                        .equals(areas[i].getName().replaceAll("\\s+", "").toLowerCase())) {

                    throw new IllegalArgumentException("areas can't have the same names");
                }
            }

        }

    }

    /*нахождение общей площади областей*/
    static double commonSquareFinder(Area... areas) {

        double commonSquare = 0;

        for (int i = 0; i < areas.length; i++) {
            commonSquare += areas[i].getSquare();
        }

        return commonSquare;
    }


}//class
