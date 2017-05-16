import java.util.Scanner;

/**
 * Created by benjaminzhang on 22/04/2017.
 * Copyright © benjaminzhang 2017.
 */

interface OneToN {
    void disp(int n);
}

class Sum implements OneToN {
    public void disp(int n) {
        int temp = 0;
        for (int i = 0; i < n; i++)
            temp += i;
        System.out.println("Sum.disp: " + temp);
    }
}

class Pro implements OneToN {
    public void disp(int n) {
        int temp = 1;
        for (int i = 1; i <= n; i++)
            temp *= i;
        System.out.println("Pro.disp: " + temp);
    }
}

public class Exercise5_23 {
    public static void main(String[] args) {
        int n;
        System.out.println("Please input n:");
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        Sum sum = new Sum();
        Pro pro = new Pro();
        sum.disp(n);
        pro.disp(n);
    }
}
