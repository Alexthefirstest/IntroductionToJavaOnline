/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 * 8. В числовой матрице поменять местами два столбца любых столбца,
 * т. е. все элементы одного столбца поставить на соответствующие им позиции другого,
* а его элементы второго переместить в первый.
* Номера столбцов вводит пользователь с клавиатуры.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

import java.util.Arrays;

public class T8_MatrixColumnChanger {
    public static void main(String[] args) {


        int [][] matrix= new int[][]{{1,2,3}, {4,-5,6}, {7,8,9}};

        int column_1=1;
        int column_2=3;

        int columnCopy;

        column_1--;
        column_2--;

        for(int i=0; i<matrix.length; i++){
             columnCopy=matrix[i][column_1];
            matrix[i][column_1]=matrix[i][column_2];
            matrix[i][column_2]=columnCopy;
        }

        for(int i=0; i<matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
