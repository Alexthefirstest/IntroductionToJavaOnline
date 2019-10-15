/*
 *
 *  Programming with classes
 *
 *
 *  2.Агрегация и композиция
 *
 *  3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
 * столицу, количество областей, площадь, областные центры.
 *
 * city->area->region->country
 *
 * - psvm only
 */

package by.epam.programmingWithClasses.agrigationAndComposition.t3_CountryCreator;

public class T3_CountryManager {

    public static void main(String[] args) {


        City city1 = new City("justCity");
        City city2 = new City("CapitalSity", "capital");
        City city3 = new City("first region center", "regional center");

        City city4 = new City("Capital2", "capital");

        City city5 = new City("second region center", "regional center");
        City city6 = new City("justCity");

        Area area1 = new Area("FirstArea", 5, city1, city2, city4 /*, city5*/ /*, city6*/);

        City city10 = new City("justCity1");
        City city11 = new City("justCity2");


        Area area2 = new Area("SecondArea", 3, city10, city11);

        Region region1 = new Region("region1", area1, area2);

        City city21 = new City("justCity21");
        City city22 = new City("justCity22");
        Area area3 = new Area("SecondArea4", 3, city21, city22);

        City city41 = new City("justCity41");
        City city42 = new City("regcent42", "regional center");
        Area area4 = new Area("SecondArea5", 7, city41, city42);

        Region region2 = new Region("region2", area3, area4);


        Country country = new Country("Cool country", region1, region2);


        country.printCapital();
        country.printRegionsQuantity();
        country.printSquare();
        country.printRegionsCenters();
    }
}//class




