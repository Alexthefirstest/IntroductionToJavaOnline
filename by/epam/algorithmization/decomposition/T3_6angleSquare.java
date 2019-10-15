/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Декомпозиция с использованием методов (подпрограммы)
 *
 *  3. Вычислить площадь правильного шестиугольника со стороной а,
 * используя метод вычисления площади треугольника.
 *
 */

package by.epam.algorithmization.decomposition;

public class T3_6angleSquare {

    public static void main(String[] args) {

        double a = 3;
        System.out.println(sixAngleSquare(a));
    }

    public static double equiateralTriangleSuare(double a) {
        return (Math.pow(a, 2) * Math.sqrt(3)) / 4;
    }

    public static double sixAngleSquare(double a) {
        return 6 * equiateralTriangleSuare(a);
    }

}
