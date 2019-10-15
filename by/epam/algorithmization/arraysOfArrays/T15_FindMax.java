/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T15_FindMax {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 5, 5,5}, {0, 1, 1,1}, {3, 8, 8,7}, {4,0,0,10}};

        int max=matrix[0][0];

        for(int i=0; i<matrix.length; i++){

            for(int j=0; j<matrix[0].length;j++){

                if (matrix[i][j]>max){
                    max=matrix[i][j];
                }

            }

        }

        for(int i=0; i<matrix.length; i++){

            for(int j=0; j<matrix[0].length;j++){

                if (matrix[i][j]%2!=0 && matrix[i][j]!=0){
                    matrix[i][j]=max;
                }

            }

        }

        System.out.println("Максимум: "+max);

        for(int i=0; i<matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
