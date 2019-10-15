/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  9. Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 * Написать метод(методы) вычисления его площади, если угол между сторонами длиной X и Y— прямой
 *
 */

package by.epam.algorithmization.decomposition;

public class T9_4EngleSquare {

    public static void main(String[] args) {
        double x=2;
        double y=4;
        double z=2;
        double t=4;
        System.out.println(fourAngleSquare(x,y,z,t));
    }

    public static double strenghtAngleSquare(double x, double y){

        return (x*y*0.5);
    }

    public static double hypotenuseFinder(double x, double y){
        return Math.sqrt(x*x+y*y);
    }

    public static double trianglePerimetr(double z, double t, double thirdSide){
        return z+t+thirdSide;
    }

    public static double triangleSquare(double z, double t, double thirdSide){

       double halfOfPerimetr=trianglePerimetr(z,t,thirdSide)/2;

        return Math.sqrt(halfOfPerimetr*(halfOfPerimetr-z)*(halfOfPerimetr-t)*(halfOfPerimetr-thirdSide));
    }

    public static double fourAngleSquare(double x, double y, double z, double t){

        double firstTriangleSquare=strenghtAngleSquare(x, y);
        double hypotenuse=hypotenuseFinder(x,y);
        double secondTriangleSquare=triangleSquare(z, t, hypotenuse);

        return firstTriangleSquare+secondTriangleSquare;
    }

}
