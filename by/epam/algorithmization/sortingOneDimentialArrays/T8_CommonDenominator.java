/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  8.Даны дроби pi/qi, pi и qi - натуральные).
 * Составить программу, которая приводит эти дроби к общему знаменателю
 * и упорядочивает их в порядке возрастания.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

public class T8_CommonDenominator {

    public static void main(String[] args) {

        int[] p = new int[]{10, 4, 6, 1, 5, 1};
        int[] q = new int[]{2, 2, 4, 6, 6, 20};
        boolean ok = false;
        int max = q[0];

        for (int i = 1; i < q.length; i++) {

            if (max < q[i]) {
                max = q[i];
            }

        }

        int denominator = 0;
        int whileCounter = 1;

        while (!ok) {

            denominator = whileCounter * max;

            for (int i = 0; i < q.length; i++) {

                if (denominator % q[i] == 0) {
                    ok = true;
                } else {
                    ok = false;
                    break;
                }
            }

            whileCounter++;
        }

        for (int i = 0; i < p.length; i++) {
            p[i] *= (denominator / q[i]);
        }

        int forSort;

        for (int i = p.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (p[j] > p[j + 1]) {
                    forSort = p[j + 1];
                    p[j + 1] = p[j];
                    p[j] = forSort;

                    forSort = q[j + 1];
                    q[j + 1] = q[j];
                    q[j] = forSort;
                }
            }
        }

        System.out.print("Дроби в порядке возрастания (общий знаменатель): ");

        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + "/" + (denominator) + ", ");
        }

        System.out.print("\nДроби в порядке возрастания: ");

        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] / (denominator / q[i]) + "/" + q[i] + ", ");
        }
    }
}
