package Exercise5_22;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 22/04/2017.
 * Copyright © benjaminzhang 2017.
 */

abstract class Shape {      //定义一个抽象类
    double area, perimeter;

    abstract void computeArea();        //子类定义此方法

    abstract void computePerimeter();       //子类定义此方法

    void display() {        //子类覆盖此方法
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perimeter);
    }
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

    void computePerimeter() {
        perimeter = -1;
    }

    @Override
    void display() {
        System.out.println("\nTriangle:");
        System.out.println("a: " + a + " h: " + h);
        super.display();
    }
}

class RightTriangle extends Triangle {
    RightTriangle(double a, double b) {
        super(a, b);
    }

    @Override
    void computePerimeter() {
        perimeter = a + h + Math.sqrt(a * a + h * h);
    }

    @Override
    void display() {
        System.out.println("\nRight triangle:");
        System.out.println("a: " + a + " b: " + h);
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perimeter);
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

    void computePerimeter() {
        perimeter = width * 2 + height * 2;
    }

    @Override
    void display() {
        System.out.println("\nRectangle:");
        System.out.println("width: " + width + " height: " + height);
        super.display();
    }
}

class Square extends Rectangle {
    Square(double a) {
        super(a, a);
    }

    @Override
    void display() {
        System.out.println("\nSquare:");
        System.out.println("a: " + width);
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perimeter);
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

    void computePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    void display() {
        System.out.println("\nCircle:");
        System.out.println("radius: " + radius);
        super.display();
    }
}

public class Exercise5_22 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[4];
        Scanner input = new Scanner(System.in);
        System.out.println("Please input triangle's a and h:");
        shape[0] = new Triangle(input.nextDouble(), input.nextDouble());
        System.out.println("Please input right triangle's a and b:");
        shape[1] = new RightTriangle(input.nextDouble(), input.nextDouble());
        System.out.println("Please input square's a:");
        shape[2] = new Square(input.nextDouble());
        System.out.println("Please input circle's radius:");
        shape[3] = new Circle(input.nextDouble());
        for (int i = 0; i < 4; i++) {
            shape[i].computeArea();;
            shape[i].computePerimeter();;
            shape[i].display();
        }
    }
}
