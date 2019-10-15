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
 * Возможно этот вариант медленее
 *
 */

package by.epam.algorithmization.decomposition;

import java.util.Arrays;
import java.util.stream.IntStream;

public class T4A__DistanceBetweenPoints {

    public static void main(String[] args) {

        int[][] pointsPositions = new int[][]{{-6, 5}, {0, 7}, {-7, 14}, {0, 21}, {-1, 14}, {6, 5}};

        printResult(pointsPositions);
    }


    public static int[] biggestDistanceFinder(int points[][]) {

        int biggestDistance = 0;
        int[][] distances = new int[points.length][points.length];

        for (int i = 0; i < points.length - 1; i++) {

            for (int j = i + 1; j < points.length; j++) {
                distances[i][j] = (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));

                if (biggestDistance < distances[i][j]) {

                    biggestDistance = distances[i][j];
                }
            }

        }

        int[] biggestDistancePoints = new int[4];
        int[] allBiggestDistancePoints = new int[0];

        for (int i = 0; i < points.length - 1; i++) {

            for (int j = i + 1; j < points.length; j++) {

                if (biggestDistance == distances[i][j]) {

                    System.arraycopy(points[i], 0, biggestDistancePoints, 0, 2);
                    System.arraycopy(points[j], 0, biggestDistancePoints, 2, 2);

                    allBiggestDistancePoints = IntStream.concat(Arrays.stream(allBiggestDistancePoints), Arrays.stream(biggestDistancePoints)).toArray();

                }

            }

        }
        return allBiggestDistancePoints;
    }

    public static void printResult(int[][] points) {

        int[] result = biggestDistanceFinder(points);

        System.out.println("Наибольшие(равные) расстояниея между точками:");

        for (int i = 0; i < result.length; i += 4)
            System.out.println("[(" + result[i] + ";" + result[i + 1] + "),(" + result[i + 2] + ";" + result[i + 3] + ")]");
    }
}
