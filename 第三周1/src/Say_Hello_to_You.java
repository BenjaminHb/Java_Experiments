/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
import java.io.IOException;
import java.util.*;

public class Say_Hello_to_You {
    public static void main(String[] args) throws IOException{
        Scanner reader=new Scanner(System.in);
        System.out.print("Enter your name:");
        String name=reader.next();
        System.out.println("Hello,Mr."+ name +"! How old are you?");
        int age=reader.nextInt();
        System.out.println("Really? You said you are "+ age +" years old, but you look so young!");
    }
}
