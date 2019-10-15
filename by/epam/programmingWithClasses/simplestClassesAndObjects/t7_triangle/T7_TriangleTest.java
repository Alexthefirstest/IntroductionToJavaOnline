/*
 *
 *    Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
 * вычисления площади, периметра и точки пересечения медиан.
 *
 * -только public static void main
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t7_triangle;

import java.util.Arrays;

public class T7_TriangleTest {

    public static void main(String[] args) {

        Triangle[] triangles = new Triangle[1];

        triangles[0] = triangles[0].createTriangleByThreePoints(1, 1, 1, 3, 3, 1);


        for (int i = 0; i < triangles.length; i++) {
            System.out.println(Arrays.toString(triangles[i].getSidesAndAngles()));
            System.out.println(triangles[i].trianglePerimeth() + "  " + triangles[i].triangleSquare() + " центр пересечения медиан : "
                    + Arrays.toString(triangles[i].centerOfMedians()));
        }
    }
}//class


