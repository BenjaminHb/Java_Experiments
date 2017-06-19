/**
 * Created by benjaminzhang on 11/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class GenerateCatchException {
    public static void main(String[] args) {
        try {
            int[] arrayNegativeArraySize = new int[-1];
        }
        catch (NegativeArraySizeException e) {
            System.out.println("NegativeArraySizeException caught.");
        }
        try {
            int[] array = new int[10];
            array[10] = 1;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundException caught.");
        }
    }
}
