/*
 *
 *  2. Algorithmization
 *
 *
 *  3. Одномерные массивы. Сортировки.
 *
 *  7. Пусть даны две неубывающие последовательности действительных чисел a1 <=a2 <= an и b1 <= b2 <= bm
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 < b2 < bm
 * в первую последовательность так, чтобы новая последовательность оставалась возрастающей.
 *
 */

package by.epam.algorithmization.sortingOneDimentialArrays;

public class T7_ArraysMergePlaces {

    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 44, 55, 90};
        int[] b = new int[]{-1, 0, 2, 30, 40, 40, 50, 60, 100};

        int j;
        int preJ = 0;

        for (int i = 0; i < b.length; i++) {
            j = a.length - 1;

            while (j >= 0 && b[i] < a[j]) {
                j--;
            }

            if (j == a.length - 1) {
                System.out.print("\nЧисло " + b[i] + "  необходимо вставить после элемента " + a[j] + ", ");
            } else if (j < 0) {
                System.out.print("\nЧисло " + b[i] + "  необходимо вставить перед элементом " + a[0] + ", ");
            } else {
                System.out.print("\nЧисло " + b[i] + "  необходимо вставить между элементами " + a[j] + " и " + a[j + 1] + ", ");
            }

            if (i > 0 && preJ == j) {
                System.out.print("после уже добавленного числа " + b[i - 1] + ", ");
            }

            preJ = j;

        }

    }
}
