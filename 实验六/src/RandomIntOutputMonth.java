import java.util.Random;

/**
 * Created by benjaminzhang on 17/04/2017.
 * Copyright © benjaminzhang 2017.
 */
public class RandomIntOutputMonth {
    public static void main(String[] args) {
        String[] month = new String[12];
        Random random = new Random();
        month[0] = "January";
        month[1] = "February";
        month[2] = "March";
        month[3] = "April";
        month[4] = "May";
        month[5] = "June";
        month[6] = "July";
        month[7] = "August";
        month[8] = "September";
        month[9] = "October";
        month[10] = "November";
        month[11] = "December";
        for (int i=0; i < 12; i++) {
            int ran = random.nextInt(12) + 1;
            System.out.println("Generate random integer is " + ran + ".\tMonth is " + month[ran - 1]);
        }
    }
}
