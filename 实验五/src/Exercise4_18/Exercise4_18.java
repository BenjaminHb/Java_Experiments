package Exercise4_18;

/**
 * Created by benjaminzhang on 28/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise4_18 {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("Accessing public variable: testPublic = "+test.testPublic);
        System.out.println("Accessing protected variable: testProtected = "+test.testProtected);
        //System.out.println("Accessing private variable: testPrivate = " + test.testPrivate);
        System.out.println("Failed while accessing private variable: testPrivate.");
    }
}
