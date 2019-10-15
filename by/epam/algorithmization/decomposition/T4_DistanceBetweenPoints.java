/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  4. На плоскости заданы своими координатами n точек.
 * Написать метод(методы), определяющие, между какими из пар точек самое большое расстояние.
 * Указание. Координаты точек занести в массив.
 *
 * Возможно этот вариант бысрее.
 *
 */

package by.epam.algorithmization.decomposition;

import java.util.Arrays;
import java.util.stream.IntStream;

public class T4_DistanceBetweenPoints {

    public static void main(String[] args) {
        int[][] pointsPositions = new int[][]{{-6, 5}, {0, 7}, {-7, 14}, {0, 21}, {-1, 14}, {6, 5}};

        printResult(pointsPositions);

    }

    /* поиск самых дальних от 0 точек*/
    public static int[] farestPointFinder(int[][] points) {

        int[] farrestPoint = points[0];

        for (int i = 1; i < points.length; i++) {

            if ((Math.abs(points[i][0]) + Math.abs(points[i][1])) > (Math.abs(farrestPoint[0]) + Math.abs(farrestPoint[1]))) {
                farrestPoint = points[i];
            }
        }

        int[] allFarestPoint = new int[0];

        for (int i = 1; i < points.length; i++) {

            if ((Math.abs(points[i][0]) + Math.abs(points[i][1]))
                    == (Math.abs(farrestPoint[0]) + Math.abs(farrestPoint[1]))) {
                allFarestPoint = IntStream.concat(Arrays.stream(allFarestPoint), Arrays.stream(points[i])).toArray();
            }
        }

        return allFarestPoint;
    }


    public static int[] biggestDistenceFinder(int[][] points) {

        int[] finalResult = new int[0];
        int preBiggestDistance = -1;

        int allfarrestPoint[] = farestPointFinder(points);

        for (int j = 0; j < allfarrestPoint.length; j += 2) {

            int farrestPoint[] = {allfarrestPoint[j], allfarrestPoint[j + 1]};
            int biggestDistancePoint[] = farrestPoint;

            int distances[] = new int[points.length];
            int biggestDistance = 0;

            for (int i = 0; i < points.length; i++) {

                int biggestDistancePointAndFarrestPointDistance = Math.abs(biggestDistancePoint[0] -
                        farrestPoint[0]) + Math.abs(biggestDistancePoint[1] - farrestPoint[1]);

                distances[i] = Math.abs(points[i][0] - farrestPoint[0]) + Math.abs(points[i][1] - farrestPoint[1]);

                if (distances[i] > biggestDistancePointAndFarrestPointDistance) {
                    biggestDistancePoint = points[i];
                    biggestDistance = distances[i];
                }

            }

            int[] theSameBiggestDistances = new int[0];

            for (int i = 0; i < points.length; i++) {

                if (biggestDistance == distances[i]) {
                    theSameBiggestDistances =
                            IntStream.concat(Arrays.stream(theSameBiggestDistances), Arrays.stream(points[i])).toArray();
                }

            }

            if (biggestDistance < preBiggestDistance) {
                continue;
            }


            theSameBiggestDistances =
                    IntStream.concat(Arrays.stream(farrestPoint), Arrays.stream(theSameBiggestDistances)).toArray();


            int[] almostFinalResult = new int[theSameBiggestDistances.length + 1];

            almostFinalResult[0] = theSameBiggestDistances.length;
            System.arraycopy(theSameBiggestDistances, 0,
                    almostFinalResult, 1, theSameBiggestDistances.length);


            if (biggestDistance == preBiggestDistance) {
                finalResult = IntStream.concat(Arrays.stream(finalResult), Arrays.stream(almostFinalResult)).toArray();
            }

            if (biggestDistance > preBiggestDistance) {
                finalResult = almostFinalResult;
            }

            preBiggestDistance = biggestDistance;
        }
        return finalResult;
    }


    static public void printResult(int[][] points) {

        int result[] = biggestDistenceFinder(points);

        System.out.println("Наибольшие(равные) расстояния между точками: ");

        int counter = 0;
        int quantity;

        while (counter < result.length) {
            System.out.println();
            quantity = result[counter];

            for (int i = counter + 3; i < counter + 3 + quantity - 2; i += 2) {
                System.out.println("[(" + result[counter + 1] + ";" + result[counter + 2] +
                        "),(" + result[i] + ";" + result[i + 1] + ")]");
            }

            counter = counter + quantity + 1;
        }
    }

}
