import java.util.Random;
import java.util.Scanner;

/**
 * Created by benjaminzhang on 17/04/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Search {
    private int binSearch(int searchInt, int n, int[] array){
        int low = 0, high = n -1 ,mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (array[mid] == searchInt)
                return mid + 1;
            if (array[mid] > searchInt)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] intarray = new  int[25];
        int inputInt, searchStatus, temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Generate random integer array:");
        for (int i = 0; i < 25; i++) {
            intarray[i] = random.nextInt(100);
            System.out.print(intarray[i]+"\t");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        for (int i = 24; i > 0; i--)
            for (int j = 0; j < i; j++) {
                if (intarray[j] > intarray[j + 1]) {
                    temp = intarray[j];
                    intarray[j] = intarray[j + 1];
                    intarray[j + 1] = temp;
                }
            }
        System.out.println("\nAfter sort:");
        for (int i = 0; i < 25; i++) {
            System.out.print(intarray[i]+"\t");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\nPlease enter integer which you want to search:");
        inputInt = input.nextInt();
        Search a = new Search();
        searchStatus = a.binSearch(inputInt, 25, intarray);
        if (searchStatus == -1) {
            System.out.println("Seach " + inputInt + " in integer array FAILED!");
            System.out.println("ERROR: integer NOT FOUND!");
            System.exit(-1);
        }else {
            System.out.println("Seach " + inputInt + " in integer array SUCCESSED!");
            System.out.println(inputInt + ":" + searchStatus);
        }
    }
}
