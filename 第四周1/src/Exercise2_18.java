import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_18 {
    private static void MultRow(double matrix[][], int row){
        double a;
        for (int i = 0; i < matrix.length; i++){
            a = (i == row)? matrix[row][row]/1.0 : -matrix[i][row]/matrix[row][row];
            for (int j = 0; j < matrix[i].length; j++){
                if (i == row){
                    matrix[i][j] /= a;
                }
                else
                    matrix[i][j] += a*matrix[row][j];
            }
        }
    }

    private static boolean FoundNonZero(double matrix[][], int diag){
        if (matrix[diag][diag] != 0) {
            NormalizeRow(matrix,diag);
            return true;
        }
        return false;
    }

    private static void NormalizeRow(double matrix[][], int row){
        MultRow(matrix, row);
    }

    private static boolean Normalizematrix(double matrix[][]){
        for (int row = 0; row < matrix.length; row++){
            if (FoundNonZero(matrix, row)) {
                NormalizeRow(matrix, row);
                System.out.println("Executing normalize. Current matrix is below:");
                Showmatrix(matrix);
            }
            else
                return false;
        }
        return true;
    }

    private static void Showmatrix(double matrix[][]){
        for (int i=0;i<matrix.length;i++){
            for (int j = 0; j <matrix[i].length;j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static double[][] Creatematrix(){
        System.out.println("Enter number of Variables:");
        Scanner input = new Scanner(System.in);
        int numVar = input.nextInt();
        double[][] matrix = new double[numVar][numVar+1];
        for (int row = 0; row < numVar; row++){
            for (int col = 0; col < numVar; col++){
                System.out.println("Coefficient row" + (row + 1) + " ,column" + (col + 1) + ":");
                matrix[row][col] = input.nextDouble();
            }
            System.out.println("Right hand side for row" + (row + 1) + ":");
            matrix[row][numVar] = input.nextDouble();
        }
        return matrix;
    }

    private static void PrintRes(double matrix[][]){
        System.out.println("Result are:");
        for (int i = 0; i < matrix.length; i++){
            System.out.println(matrix[i][matrix[i].length-1]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Created by benjaminzhang on 20/03/2017.\n" + "Copyright © benjaminzhang 2017.");
        double[][] matrix = Creatematrix();
        System.out.println("Input matrix is below:");
        Showmatrix(matrix);
        if (Normalizematrix(matrix)) {
            System.out.println("Executed normalize. Matrix is below:");
            Showmatrix(matrix);
            PrintRes(matrix);
        }
        else
            System.out.println("No solution or no unique solution.");
    }
}
