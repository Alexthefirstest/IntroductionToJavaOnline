/*
 *
 *   Programming with classes
 *
 *
 *  1.Простейшие классы и объекты.
 *
 *  7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
 * вычисления площади, периметра и точки пересечения медиан.
 *
 */

package by.epam.programmingWithClasses.simplestClassesAndObjects.t7_triangle;

import static java.lang.Math.*;

public class Triangle {

    /*для обращения к конструктору используется статический метод*/
    private Triangle(double point1_x, double point1_y,
                     double point2_x, double point2_y,
                     double point3_x, double point3_y,
                     double side1, double side2, double side3,
                     double angle1, double angle2, double angle3) {

        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("wrong coordinates");
        }

        if (angle1 <= 0 || angle2 <= 0 || angle3 <= 0) {
            throw new IllegalArgumentException("wrong coordinates");
        }

        this.point1_x = point1_x;
        this.point1_y = point1_y;
        this.point2_x = point2_x;
        this.point2_y = point2_y;
        this.point3_x = point3_x;
        this.point3_y = point3_y;
        this.angle1 = angle1;
        this.angle2 = angle2;
        this.angle3 = angle3;

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    private double point1_x;
    private double point1_y;
    private double point2_x;
    private double point2_y;
    private double point3_x;
    private double point3_y;

    private double angle1;
    private double angle2;
    private double angle3;


    private double side1;
    private double side2;
    private double side3;


    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getAngle1() {
        return angle1;
    }

    public double getAngle2() {
        return angle2;
    }

    public double getAngle3() {
        return angle3;
    }

    public double[] getSidesAndAngles() {

        double[] parametrs = new double[6];
        parametrs[0] = side1;
        parametrs[1] = side1;
        parametrs[2] = side2;
        parametrs[3] = angle1;
        parametrs[4] = angle2;
        parametrs[5] = angle3;

        return parametrs;
    }

    static double findSideByPoints(double point1_x, double point1_y,
                                   double point2_x, double point2_y) {
        return sqrt(pow((point1_x - point2_x), 2) + pow((point1_y - point2_y), 2));

    }

    static public Triangle createTriangleByThreePoints(double point1_x, double point1_y,
                                                       double point2_x, double point2_y,
                                                       double point3_x, double point3_y) {


        double side1 = findSideByPoints(point1_x, point1_y, point2_x, point2_y);
        double side2 = findSideByPoints(point2_x, point2_y, point3_x, point3_y);
        double side3 = findSideByPoints(point1_x, point1_y, point3_x, point3_y);


        double angle1 = toDegrees(acos((pow(side2, 2) + pow(side3, 2) - pow(side1, 2)) / (2 * side2 * side3)));
        double angle2 = toDegrees(acos((pow(side1, 2) + pow(side3, 2) - pow(side2, 2)) / (2 * side1 * side3)));
        double angle3 = 180 - angle1 - angle2;

        Triangle triangle = new Triangle(point1_x, point1_y, point2_x, point2_y,
                point3_x, point3_y, side1, side2, side3,
                angle1, angle2, angle3);

        return triangle;
    }


    public double trianglePerimeth() {
        return side1 + side2 + side3;
    }

    public double triangleSquare() {

        double p = (side1 + side2 + side3) / 2;

        return sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }


    public double[] centerOfMedians() {

        double[] center = new double[2];

        center[0] = (point1_x + point2_x + point3_x) / 3;
        center[1] = (point1_y + point2_y + point3_y) / 3;

        return center;
    }

}
