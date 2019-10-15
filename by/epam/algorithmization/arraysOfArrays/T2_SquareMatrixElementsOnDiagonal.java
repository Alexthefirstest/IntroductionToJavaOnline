/*
 *
 *  2. Algorithmization
 *
 *
 *  2. массивы массивов
 *
 *  2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 *
 */

package by.epam.algorithmization.arraysOfArrays;

public class T2_SquareMatrixElementsOnDiagonal {

    public static void main(String[] args) {

        int [][] matrix= new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int length= matrix.length;

        for(int i=0; i<length; i++){
            System.out.print(matrix[i][i]+", ");
        }

    }
}
