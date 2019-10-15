/*
*
* класс для загрузки сокровищ из файла
*
* проверяет правильность количества сокровищ и правильность данных в файле
*
*/

package by.epam.basicsOfOOP.t4_DragonsTreasure.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

class LoadTreasures {

    private Treasure[] treasures;

    public Treasure[] getTreasures() {

        loadTreasures(".\\src\\by.epam.basicsOfOOP.t4_DragonsTreasure.TreasuresList\\treasures.txt");

        return treasures;
    }

    private int i = 0;

    public void loadTreasures(String fileName) {

        try {

            treasures = new Treasure[100];

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;

            for (int k = 0; k < 100; k++) {

                line = reader.readLine();
                if (line == null) {
                    throw new IllegalArgumentException("wrong lines quantity: " + k);
                }

                if (inputLineCheck(line) == true) {
                    addTreasure(line);
                } else {
                    throw new IllegalArgumentException("input line incorrect: " + line);
                }

            }
            reader.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static boolean inputLineCheck(String inputLine) {

        String[] inputLineArr = inputLine.split("/");

        if (Pattern.matches("\\d+", inputLineArr[1].replaceAll("//s+", ""))) {

            return true;
        } else {
            return false;
        }
    }

    private void addTreasure(String line) {

        String[] treasure = line.split("/");

        treasures[i] = new Treasure(treasure[0], Integer.parseInt(treasure[1].replaceAll("//s+", "")));

        i++;
    }

}
