package Exercise5_8;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 22/04/2017.
 * Copyright © benjaminzhang 2017.
 */

abstract class Shape {      //定义一个抽象类
    double area;

    abstract void computeArea();        //子类定义此方法
}

class Triangle extends Shape {
    double a, h;

    Triangle(double a, double h) {
        this.a = a;
        this.h = h;
    }

    void computeArea() {
        area = a * h / 2;
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    void computeArea() {
        area = width * height;
    }
}

class Square extends Rectangle {
    Square(double a) {
        super(a, a);
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void computeArea() {
        area = Math.PI * radius * radius;
    }
}

public class Exercise5_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input triangle's a and h:");
        Triangle tri = new Triangle(input.nextDouble(), input.nextDouble());
        System.out.println("Triangle's a: " + tri.a + " h: " + tri.h);
        System.out.println("Please input square's a:");
        Square squ = new Square(input.nextDouble());
        System.out.println("Square's a: " + squ.width);
        System.out.println("Please input circle's radius:");
        Circle cir = new Circle(input.nextDouble());
        System.out.println("Ciecle's radius: " + cir.radius);
        tri.computeArea();      //调用类的计算面积方法
        squ.computeArea();      //调用类的计算面积方法
        cir.computeArea();      //调用类的计算面积方法
        System.out.println("\nTriangle's area is " + tri.area);
        System.out.println("Square's area is " + squ.area);
        System.out.println("Circle's area is " + cir.area);
    }
}
