import java.util.Scanner;

/**
 * Created by benjaminzhang on 22/04/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise5_24 implements OneToN {
    public static void main(String[] args) {
        System.out.println("Please input n:");
        Scanner input = new Scanner(System.in);
        Exercise5_24 exp = new Exercise5_24();
        exp.disp(input.nextInt());
    }

    public void disp(int n) {
        System.out.println("Input n is: " + n);
    }
}
