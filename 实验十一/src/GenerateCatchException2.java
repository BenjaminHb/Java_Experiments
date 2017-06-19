/**
 * Created by benjaminzhang on 18/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class GenerateCatchException2 {
    public static void main(String[] args) {
        try {
            int[] arrayNegativeArraySize = new int[-1];
        }
        catch (NegativeArraySizeException e) {
            System.out.println("NegativeArraySizeException\tcaught.");
        }
        try {
            int[] array = new int[10];
            array[10] = 1;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundException\tcaught.");
        }
        try {
            int[] intNull = null;
            intNull[0] = -1;
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException\t\tcaught.");
        }
    }
}
