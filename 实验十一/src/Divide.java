import java.io.File;
import java.io.IOException;

/**
 * Created by benjaminzhang on 11/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Divide {
    public static int divide(int[] array, int index){
        try {
            System.out.println("\nFirst try block divide() entered.");
            array[index+2] = array[index]/array[index+1];
            System.out.println("Code at end of first try block in divide().");
            return array[index+2];
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic exception caught in divide(). " +
                    "Code at end of first catch block in divide().");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index_out_of_bound exception caught in divide().");
        }
        finally {
            System.out.println("Finally block in divide().");
        }
        System.out.println("Executing code after try block in divide().");
        return array[index+2];
    }

    public static void main(String[] args) {
        int[] x = {10,5,0};
        try {
            System.out.println("First try block in main() block.");
            System.out.println("Result = "+divide(x,0));
            x[1] = 0;
            System.out.println("Result = "+divide(x,0));
            x[1] = 1;
            System.out.println("Result = "+divide(x,0));
        }
        catch (ArithmeticException e){
            System.out.println("Arithmetic exception caught in main(). " +
                    "Code at end of first catch block in main().");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index_out_of_bound exception caught in main().");
        }
        System.out.println("Outside first try block in main().");
        System.out.println("\nPress enter to exit.");
        try {
            // Removing error only
            // Error: java: exception java.io.IOException is never thrown in body of corresponding try statement
            File removeErrorUsageOnlyTemp = new File("~/xqeadadasfas");
            removeErrorUsageOnlyTemp.createNewFile();
        }
        catch (IOException e){
            System.out.println("I/O exception caught in main().");
        }
        finally {
            System.out.println("Finally block for second in main().");
        }
        System.out.println("Code after second try block in main().");
    }
}
