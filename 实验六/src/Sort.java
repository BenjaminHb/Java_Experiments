import java.util.Random;

/**
 * Created by benjaminzhang on 17/04/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Sort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] intarray = new int[20];
        int temp;
        System.out.println("Before sort:");
        for (int i = 0; i < 20; i++) {
            intarray[i] = random.nextInt();     //随机生成一个整数
            System.out.print(intarray[i] + "\t");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }

        for (int i = 19; i > 0; i--)        //冒泡排序
            for (int j = 0; j < i; j++) {
                if (intarray[j] > intarray[j + 1]) {
                    temp = intarray[j];
                    intarray[j] = intarray[j + 1];
                    intarray[j + 1] = temp;
                }
            }
        System.out.println("\nAfter sort:");
        for (int i = 0; i < 20; i++) {
            System.out.print(intarray[i] + "\t");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
    }
}
