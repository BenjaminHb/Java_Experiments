import java.util.Scanner;

/**
 * Created by benjaminzhang on 28/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise4_19 {
    private static double rectangleL, rectangleW, cubeL, cubeW, cubeH, sphereR;

    private static void setRectangle(double a, double b){
        rectangleL = a;
        rectangleW = b;
    }

    private static void setCube(double l, double w, double h){
        cubeL = l;
        cubeW = w;
        cubeH = h;
    }

    private static void setSphere(double r){
        sphereR = r;
    }

    private static double calRectangleArea(){
        double s;
        s = rectangleL * rectangleW;
        return s;
    }

    private static double calCubeVolume(){
        double v;
        v = cubeL * cubeW * cubeH;
        return v;
    }

    private static double calSphereVolume(){
        double v;
        v = Math.pow(sphereR,3) * 4.0 / 3.0 * Math.PI;
        return v;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input rectangle's length and weight:");
        rectangleL = input.nextDouble();
        rectangleW = input.nextDouble();
        System.out.println("Please input cube's length, weight and height:");
        cubeL = input.nextDouble();
        cubeW = input.nextDouble();
        cubeH = input.nextDouble();
        System.out.println("Please input sphere's radius:");
        sphereR = input.nextDouble();
        System.out.println("Rectangle's area is "+calRectangleArea());
        System.out.println("Cube's volume is "+calCubeVolume());
        System.out.println("Sphere's volume is "+calSphereVolume());
    }
}
