/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T3_PrintLineAndColumn {

    public static void main(String[] args) {

        int [][] matrix= new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int k=2;
        int p=3;

        System.out.println(Arrays.toString(matrix[k-1]));
        System.out.println();

        for(int i=0; i<matrix.length;i++){
            System.out.print(matrix[i][p-1]+"\n");
        }

    }
}
