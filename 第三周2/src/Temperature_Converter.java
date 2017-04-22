import java.io.IOException;
import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Temperature_Converter {
    public static void main(String[] args) throws IOException{
        Scanner input=new Scanner(System.in);       //新建一个对象来扫描用户输入
        System.out.println("Please enter Celsius temperature.");
        double inputCelsius=input.nextDouble();
        double outputFahrenheit=1.8*inputCelsius+32;
        System.out.println("Celsius temperature is "+inputCelsius+" ˚C");
        System.out.println("Fahrenheit temperature is "+outputFahrenheit+" ˚F");
    }
}
